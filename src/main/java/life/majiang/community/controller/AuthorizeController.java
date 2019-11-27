package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/*
**
**@Param: 11.23
**@return:
**
*/
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clietnSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clietnSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String accessToken = githubProvider.getAccessToke(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        //System.out.println(githubUser.getId());
        if (githubUser != null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            //string.valueOf()
            user.setAccountId(githubUser.getId().toString());
            user.setGmtCreate(System.currentTimeMillis());//毫秒值
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            //登录成功，写session和cookies
            request.getSession().setAttribute("user",githubUser);
            //回跳根目录
            return "redirect:/";
        }else {
            //登陆失败，重新登录
            return "redirect:/";
        }
        //return "index";
    }


}

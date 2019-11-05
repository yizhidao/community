package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
**
**@Param: 2019 0928
**@return: 
**
*/
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello(){
        return "index";
    }
}

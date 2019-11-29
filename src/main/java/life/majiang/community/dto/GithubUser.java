package life.majiang.community.dto;

import lombok.Data;

/*
**
**@Param: 授权（数据传输）
**@return:
**
*/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;


}

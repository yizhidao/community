package life.majiang.community.dto;

import lombok.Data;

/*
**
**@Param: 授权（数据传输）
**@return:
**
*/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}

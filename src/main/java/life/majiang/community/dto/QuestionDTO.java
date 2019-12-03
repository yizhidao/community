package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/*
**
**@Param: 2019 1130
**@return:
**
*/
@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private User user;

}

package com.circle.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@ApiModel("用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static final long serialVersionUID = -4415517704211731385L;
    private Integer userId;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String userPass;

    private String userNickname;

    private String userEmail;

    private String userUrl;

    private String userAvatar;

    private String userLastLoginIp;

    private Date userRegisterTime;

    private Date userLastLoginTime;

    private Integer userStatus;

    /**
     * 文章数量（不是数据库字段）
     */
    private Integer articleCount;
}

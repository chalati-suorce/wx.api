package com.demo.system.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -43037868715565349L;

    @ApiModelProperty(value = "每页多少条", example = "10")
    private Integer limit;

    @ApiModelProperty(value = "第几页", example = "1")
    private Integer offset;

    @ApiModelProperty(value = "", example = " ")
    private Integer id;

    @ApiModelProperty(value = "名称", example = " ")
    private String name;

    @ApiModelProperty(value = "账号", example = " ")
    private String user;

    @ApiModelProperty(value = "手机号", example = " ")
    private String tel;

    @ApiModelProperty(value = "密码", example = " ")
    private String pwd;

    @ApiModelProperty(value = "时间", example = " ")
    public String time;

    @ApiModelProperty(value = "头像", example = " ")
    private String img;

    @ApiModelProperty(value = "身份证号", example = " ")
    private String idcard;

    @ApiModelProperty(value = "年龄", example = " ")
    private String age;

    @ApiModelProperty(value = "性别", example = " ")
    private String sex;


}

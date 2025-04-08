package com.demo.system.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 医生表
 */
@Data
public class Doctor implements Serializable {
    private static final long serialVersionUID = -40831513217804602L;

    @ApiModelProperty(value = "每页多少条", example = "10")
    private Integer limit;

    @ApiModelProperty(value = "第几页", example = "1")
    private Integer offset;

    @ApiModelProperty(value = "", example = " ")
    private Integer id;

    @ApiModelProperty(value = "账号", example = " ")
    private String user;

    @ApiModelProperty(value = "密码", example = " ")
    private String pwd;

    @ApiModelProperty(value = "名称", example = " ")
    private String name;

    @ApiModelProperty(value = "手机号", example = " ")
    private String tel;

    @ApiModelProperty(value = "时间", example = " ")
    public String time;

    @ApiModelProperty(value = "医生科室", example = " ")
    private String type;

    @ApiModelProperty(value = "图片", example = " ")
    private String img;

    @ApiModelProperty(value = "简介", example = " ")
    private String content;


}

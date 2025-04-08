package com.demo.system.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 预约表
 */
@Data
public class Orders implements Serializable {
    private static final long serialVersionUID = 330776905118135236L;

    @ApiModelProperty(value = "每页多少条", example = "10")
    private Integer limit;

    @ApiModelProperty(value = "第几页", example = "1")
    private Integer offset;

    @ApiModelProperty(value = "", example = " ")
    private Integer id;

    @ApiModelProperty(value = "预约号", example = " ")
    private String code;

    @ApiModelProperty(value = "用户id", example = " ")
    private Integer uid;

    @ApiModelProperty(value = "医生id", example = " ")
    private Integer did;

    @ApiModelProperty(value = "预约日期", example = " ")
    private String day;

    @ApiModelProperty(value = "时间", example = " ")
    public String time;

    @ApiModelProperty(value = "诊断意见", example = " ")
    private String reply;

    @ApiModelProperty(value = "状态 已预约 诊断结束", example = " ")
    private String status;


}

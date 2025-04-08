package com.demo.system.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 对话表
 */
@Data
public class Talk implements Serializable {
    private static final long serialVersionUID = 514859987027103216L;

    @ApiModelProperty(value = "每页多少条", example = "10")
    private Integer limit;

    @ApiModelProperty(value = "第几页", example = "1")
    private Integer offset;

    @ApiModelProperty(value = "", example = " ")
    private Integer id;

    @ApiModelProperty(value = "用户id", example = " ")
    private Integer uid;

    @ApiModelProperty(value = "医生id", example = " ")
    private Integer did;

    @ApiModelProperty(value = "内容", example = " ")
    private String content;

    @ApiModelProperty(value = "时间", example = " ")
    public String time;

    @ApiModelProperty(value = "订单号", example = " ")
    private String code;

    @ApiModelProperty(value = "诊断意见", example = " ")
    private String reply;

    @ApiModelProperty(value = "状态 已预约 已结束", example = " ")
    private String status;

    @ApiModelProperty(value = "信息发送者 医生 用户", example = " ")
    private String type;


}

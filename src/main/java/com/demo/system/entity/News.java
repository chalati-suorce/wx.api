package com.demo.system.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 科普知识表
 */
@Data
public class News implements Serializable {
    private static final long serialVersionUID = 161719959698765152L;

    @ApiModelProperty(value = "每页多少条", example = "10")
    private Integer limit;

    @ApiModelProperty(value = "第几页", example = "1")
    private Integer offset;

    @ApiModelProperty(value = "", example = " ")
    private Integer id;

    @ApiModelProperty(value = "标题", example = " ")
    private String name;

    @ApiModelProperty(value = "内容", example = " ")
    private String content;

    @ApiModelProperty(value = "时间", example = " ")
    public String time;


}

package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author wanganxb
 * @since 2020-04-27 09:37:10
 */
@Data
@ApiModel
public class User implements Serializable {
    private static final long serialVersionUID = -61460125187656282L;
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
}
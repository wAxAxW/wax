package com.example.demo.entity;

import com.example.demo.annotation.MyBeforeA;
import com.example.demo.utils.InsertGroup;
import com.example.demo.utils.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author
 * @date
 */
@Data
@Component
public class UserTest {
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    @NotNull(message = "主键ID为空", groups = {UpdateGroup.class})
    private Long id;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @NotEmpty(message = "姓名不能为空", groups = {InsertGroup.class}, payload = {})
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    @Min(value = 18, message = "未成年人禁止使用")
    @Max(60)
    private Integer age;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    //@Email
    private String email;

    @MyBeforeA
    public void work() {
        System.out.println("工作");
    }
}

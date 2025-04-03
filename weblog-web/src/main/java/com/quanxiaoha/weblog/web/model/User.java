package com.quanxiaoha.weblog.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ApiModel(value = "用户实体类")
public class User {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    // 性别
    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别", required = true)
    private Integer sex;
    // 年龄
    @NotNull(message = "年龄不能为空")
    @ApiModelProperty(value = "年龄", required = true)
    @Min(value = 18, message = "年龄必须大于或等于 18")  // 注解确保年龄大于等于 18
    @Max(value = 100, message = "年龄必须小于或等于 100")  // 注解确保年龄小于等于 100
    private Integer age;

    // 邮箱
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value = "邮箱", required = true)
    @Email(message = "邮箱格式不正确")  // 注解确保邮箱格式正确
    private String email;
}


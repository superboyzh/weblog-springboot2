package com.quanxiaoha.weblog.web.controller;

import com.quanxiaoha.weblog.common.enums.ResponseCodeEnum;
import com.quanxiaoha.weblog.common.exception.BizException;
import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.web.model.User;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user) {
        return Response.success();
        //1. 处理参数校验异常
        // 手动抛异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
        // throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
        // 2
        //主动定义一个运行时异常，分母不能为零
//        int i = 1 / 0;
//        return Response.success();
        // 3
        // 是否存在校验错误
//        if (bindingResult.hasErrors()) {
//            // 获取校验不通过字段的提示信息
//            String errorMsg = bindingResult.getFieldErrors()
//                    .stream()
//                    .map(FieldError::getDefaultMessage)
//                    .collect(Collectors.joining(", "));
//
//            return Response.fail(errorMsg);
//        }
//        // 返参
//        return Response.success();
    }
    @GetMapping("/test2")
    @ApiOperationLog(description = "测试接口2")
    public String test2() {
        // 返参
        return "test2";
    }
}

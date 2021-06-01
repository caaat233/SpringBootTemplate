package com.springboottemplate.exception;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/31 11:11
 */

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuang.ko
 * //ControllerAdvice 注解加参数  assignableTypes = {ExceptionController.class}  只作用于指定类
 * 关闭异常处理器，影响测试代码
 */
//@ControllerAdvice
//@ResponseBody
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
//    public String exceptionHandler(Exception e) {
//
//        if (e instanceof IllegalArgumentException) {
//            return JSONUtils.toJSONString("参数错误!");
//        } else if (e instanceof ResourceNotFoundException) {
//            return JSONUtils.toJSONString("  Sorry, the resourse not found!");
//        } else {
//            return JSONUtils.toJSONString(" 未知异常");
//        }
//    }
//}
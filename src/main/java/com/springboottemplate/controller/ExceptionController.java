package com.springboottemplate.controller;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/31 11:15
 */

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuang.kou
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
    }

}

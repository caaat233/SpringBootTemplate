package com.springboottemplate.template.service;

import com.springboottemplate.template.Result;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/16 11:27
 */
public interface ServiceTemplate {


    <T> Result<T> exction(ServiceCallback serviceCallback, Object Object) throws Exception;
}

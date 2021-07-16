package com.springboottemplate.template;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/16 11:27
 */
public interface ServiceTemplate {


    <T> Result<T> exction(ServiceCallback serviceCallback, Object Object) throws Exception;
}

package com.springboottemplate.template.service;

import com.springboottemplate.template.Result;

/**
 * @author 唐涛
 * @description: 回调函数里面定义行为
 * @date 2021/7/16 11:28
 */
public interface ServiceCallback<T> {

    /**
     * 参数检查
     * @throws Exception
     */
    void paramCheck() throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
     Result<T> executeAction() throws Exception;
}

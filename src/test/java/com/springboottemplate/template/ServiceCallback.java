package com.springboottemplate.template;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/16 11:28
 */
public interface ServiceCallback<T> {

    /**
     * 参数检查
     * @throws Exception
     */
    void paramCheck() throws Exception;

    /**
     * 其实我们可以返回result<T></>,但是我的项目没定义result，就直接返回泛型把
     * @return
     * @throws Exception
     */
     Result<T> executeAction() throws Exception;
}

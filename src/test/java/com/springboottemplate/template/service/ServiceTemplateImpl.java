package com.springboottemplate.template.service;

import com.alibaba.fastjson.JSON;
import com.springboottemplate.template.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/16 11:31
 */
public class ServiceTemplateImpl implements ServiceTemplate {
    private static final Logger log = LoggerFactory.getLogger(ServiceTemplateImpl.class);

    /**
     * 使用Callback 模式与模板方法模式配合，比继承灵活性更高
     *
     * Callback 模式：只定义接口，不具体实现，在调用的时候，匿名实现接口。（将Callback(回调)函数作为其他函数的参数传入，以便在某个时间点调用这个方法。）
     * 、
     *
     * @param serviceCallback
     * @param object
     * @param <T>
     * @return
     * @throws Exception
     */
    @Override
    public <T> Result<T> exction(ServiceCallback serviceCallback, Object object) throws Exception {
        Result<T> result = null;
        long start = System.currentTimeMillis();
        try {
            // 我们这里面先啥都不处理，就计算一下方法执行时间就行，打印一下入参
            log.debug(JSON.toJSONString(object));
            //参数检查
            serviceCallback.paramCheck();
            //
            result = serviceCallback.executeAction();
            System.out.println(JSON.toJSONString(result.getData()));
            long end = System.currentTimeMillis();
            log.debug("方法运行时间：" + (end - start));
        } catch (Exception e) { //可以先捕获自己定义的异常
            //error log
            long end = System.currentTimeMillis();
            log.error(JSON.toJSONString(object) + e.getMessage());
            result = Result.error(1, e.getMessage());
            log.error("方法运行时间：" + (end - start));
        }catch (Throwable e){
            log.error(JSON.toJSONString(object) + e.getMessage());
        }
        return result;
    }
}

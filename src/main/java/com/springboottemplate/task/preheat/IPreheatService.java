package com.springboottemplate.task.preheat;

import java.util.Date;
import java.util.List;

/**
 * @author 唐涛
 * @description: IPreheatService
 * @date 2021/10/29 15:47
 */
public interface IPreheatService<T> {
    /**
     * 预热缓存
     */
    void prepareRedisCache();


    boolean accept(String name);
}

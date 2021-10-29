package com.springboottemplate.controller;

import com.springboottemplate.task.preheat.IPreheatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 唐涛
 * @description: 缓存预热
 * @date 2021/10/29 16:35
 */
@Controller
@RequestMapping("pre")
public class PreController {


    @Resource
    List<IPreheatService> iPreheatServiceList;


    @RequestMapping("user")
    @ResponseBody
    public String preUser() {
        for (IPreheatService iPreheatService : iPreheatServiceList) {
            if (iPreheatService.accept("user")) {
                iPreheatService.prepareRedisCache();
            }
        }
        return "预热完毕";
    }


}

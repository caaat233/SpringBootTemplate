package com.springboottemplate.json.dto;

import java.util.Map;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/26 20:02
 */
public class UserDto  {


    private String remark;

    private String creator;

    private String modifier;


    private Map<String,String> feature;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Map<String, String> getFeature() {
        return feature;
    }

    public void setFeature(Map<String, String> feature) {
        this.feature = feature;
    }
}

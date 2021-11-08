package com.springboottemplate.template;


import com.springboottemplate.eumn.MyblogErrorCodeEnum;

/**
 * @author 唐涛
 * @description: 这个通用类写的比较好
 * @date 2021/11/3 17:34
 */
public class BlogResult<T> {
    private static final long serialVersionUID = 5517512345617499816L;
    /*响应码*/
    private String code;
    private boolean success = false;
    /*响应消息*/
    private String msg;
    /*流水号*/
    private String flowcode;
    /*数据单元*/
    private T data;

    public BlogResult() {
    }

    public BlogResult(T data) {
        this.success = true;
        this.data = data;
    }

    public BlogResult(boolean success, String code, String msg, String flowcode, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.flowcode = flowcode;
        this.data = data;
    }

    public static <T> BlogResult<T> ofSuccess(T data) {
        return new BlogResult<>(true, null, null, null, data);
    }

    public static <T> BlogResult<T> ofFail(MyblogErrorCodeEnum myblogErrorCodeEnum) {
        return new BlogResult<>(true, myblogErrorCodeEnum.getErrorCode(), myblogErrorCodeEnum.getErrorMsg(), null, null);
    }

    public static <T> BlogResult<T> ofFail(String errorCode, String errorMsg, T data) {
        return new BlogResult<>(false, errorCode, errorMsg, null, data);
    }


    public static <T> BlogResult<T> ofFail(String errorCode, String errorMsg) {
        return new BlogResult<>(false, errorCode, errorMsg, null, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFlowcode() {
        return flowcode;
    }

    public void setFlowcode(String flowcode) {
        this.flowcode = flowcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

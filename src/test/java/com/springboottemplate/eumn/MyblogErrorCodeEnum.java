package com.springboottemplate.eumn;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/11/3 18:15
 */

/**
 * @author 唐涛
 * @description: MyblogErrorCodeEnum 自定义美剧
 * @date 2021/11/2 18:06
 */
public enum MyblogErrorCodeEnum {

    /**
     * 系统异常
     */
    SYS_ERROR("SYS_ERROR", "系统异常"),

    /**
     * 非法参数
     */
    INVALID_PARAMS_ERROR("INVALID_PARAMS_ERROR", "参数非法"),


    /**
     * RESULT_MISS_ERROR
     */
    RESULT_IS_NULL("RESULT_IS_NUll", "result is null"),

    /**
     * RESULT_MISS_ERROR
     */
    WRITE_PROHIBITED("writeProhibited", "你没有权限调用该方法");


    private String errorCode;
    private String errorMsg;

    MyblogErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}

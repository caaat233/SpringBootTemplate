package com.springboottemplate.eumn;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/13 20:34
 */
public class ConstantTest {

    /**
     * LOGISTICS_CATEGORY
     */
    public static final String LOGISTICS_CATEGORY = "LOGISTICS_CATEGORY";

    /**
     * RESOURCE
     */
    public static final String RESOURCE = "RESOURCE";

    /**
     * SHIPPING_PROVIDER
     */
    public static final String SHIPPING_PROVIDER = "SHIPPING_PROVIDER";

    /**
     * PARTNER
     */
    public static final String PARTNER = "PARTNER";

    /**
     * CONTRACT
     */
    public static final String CONTRACT = "CONTRACT";



    public static void main(String[] args) {
        String operateType="LOGISTICS_CATEGORY";
        switch (operateType) {
            case ConstantTest.LOGISTICS_CATEGORY:
                System.out.println("LOGISTICS_CATEGORY");
                break;
            case ConstantTest.RESOURCE:

                break;
            case ConstantTest.SHIPPING_PROVIDER:

                break;
            case ConstantTest.PARTNER:

            case ConstantTest.CONTRACT:

            default:
                break;
        }
        System.out.println("剩下代码继续执行");

    }
}

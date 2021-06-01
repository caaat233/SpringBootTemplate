package com.springboottemplate.eumn;


/**
 * @author 唐涛
 * @description: AbilityNameEnum
 * @date 2021/5/27 17:48
 */
public enum AbilityNameEnum {
    FORWARD_FM("Forward FM", "FM"),

    FORWARD_LM("Forward LM", "LM");

    private String name;
    private String text;

    AbilityNameEnum(String name, String text) {
        this.name = name;
        this.text = text;
    }

    /**
     * according to Enum name ,get Enum text
     *
     * @param name
     * @return
     */
    public static String getValue(String name) {
        AbilityNameEnum[] abilityNameEnums = AbilityNameEnum.values();
        for (AbilityNameEnum abilityNameEnum : abilityNameEnums) {
            if (abilityNameEnum.getName().equals(name)) {
                return abilityNameEnum.getText();
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

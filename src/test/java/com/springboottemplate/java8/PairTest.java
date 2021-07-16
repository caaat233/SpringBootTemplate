package com.springboottemplate.java8;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author 唐涛
 * @description: PairTest
 * @date 2021/4/30 15:52
 */
public class PairTest {

    @Test
    public void testPair() {
        //测试字符串不能为空的数据
        // String s = validateFields(Pair.of("name", "张三"), Pair.of("id", "1"), Pair.of("age", ""),Pair.of("list", new ArrayList<>()));
        //测试集合不能为空的数据
        String s = validateFields(Pair.of("name", "张三"), Pair.of("id", "1"), Pair.of("age", "20"), Pair.of("list", new ArrayList<>()));
        //测试map不能为空的数据
        // String s = validateFields(Pair.of("name", "张三"), Pair.of("id", "1"), Pair.of("age", ""),Pair.of("list", new ArrayList<>()));


        System.out.println(s);


    }

    /**
     * 使用pair校验参数的工具类
     *
     * @param checkFields
     */
    public String validateFields(Pair<String, Object>... checkFields) {
        for (Pair<String, Object> checkField : checkFields) {
            Object value = checkField.getValue();
            if (checkField.getValue() == null) {
                return "参数为空的key:" + checkField.getKey() + "   左:" + checkField.getLeft() + "  右:" + checkField.getRight();
            }
            if (value instanceof String && StringUtils.isBlank((CharSequence) value)) {
                return "参数为空的key:" + checkField.getKey() + "   左:" + checkField.getLeft() + "  右:" + checkField.getRight();
            }
            if (value instanceof Collection && CollectionUtils.isEmpty((Collection<?>) value)) {
                return "参数为空的key:" + checkField.getKey() + "   左:" + checkField.getLeft() + "  右:" + checkField.getRight();
            }
            if (value instanceof Map && MapUtils.isEmpty((Map<?, ?>) value)) {
                return "参数为空的key:" + checkField.getKey() + "   左:" + checkField.getLeft() + "  右:" + checkField.getRight();
            }
        }

        return null;
    }


    @Test
    public void test(Object param) {
        if (param instanceof String && StringUtils.isBlank((CharSequence) param)) {
            //如果param参数是个字符串

        }
        if (param instanceof Collection && CollectionUtils.isEmpty((Collection<?>) param)) {
            //如果param参数是个集合
        }
        if (param instanceof Map && MapUtils.isEmpty((Map<?, ?>) param)) {
            //如果param参数是个map
        }
    }

}

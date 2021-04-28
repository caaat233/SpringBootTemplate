package com.springboottemplate.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboottemplate.json.dto.UserDto;
import org.aspectj.util.FileUtil;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ttao
 * @create: 2020-07-08 10:12
 **/
public class TestJson {

    /**
     * 测试jsonutil 把字符串转换成复杂对象
     */
    @Test
    public void test5() throws IOException {
//    String json = "\n" +
//                "{\n" +
//                "\"creator\": \"SORTATION_10006099\",\n" +
//                "\"feature\": {\n" +
//                "\"functionName\": \"222222\",\n" +
//                "\"excludeWHCode\": \"11111\"\n" +
//                "},\n" +
//                "\"modifier\": \"张三\",\n" +
//                "\"remark\": \"备注\"\n" +
//                "}";

        String  json="\n" +
                "{\n" +
                "\"creator\": \"SORTATION_10006099\",\n" +
                "\"modifier\": \"张三\",\n" +
                "\"remark\": \"备注\"\n" +
                "}";
        UserDto userDto = JSON.parseObject(json, UserDto.class);
        System.out.println(JSON.toJSONString(userDto));

        UserDto userDto1=new UserDto();
        Map<String,String> map=new HashMap<>();
        map.put("excludeWHCode","11111");
        map.put("functionName","222222");
        userDto1.setFeature(map);
        userDto1.setCreator("SORTATION_10006099");
        userDto1.setModifier("张三");
        userDto1.setRemark("备注");
        System.out.println(JSON.toJSONString(userDto1));


    }


    /**
     * 测试一下字符串转jsonObeject
     */
    @Test
    public void test4() throws IOException {
        //  File file = new File("D:\\ces.json");
        // File file = new File("classpath:ces.json");

      //  File file = new File("test/resources/ces.json");

        Resource resource = new ClassPathResource("ces.json");
        File file = resource.getFile();
        String s = FileUtil.readAsString(file);
        System.out.println(s);

        HashMap hashMap = JSONObject.parseObject(s, HashMap.class);
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println("****"+hashMap.containsValue("ID1"));
        System.out.println(hashMap.toString());
        String features = (String) hashMap.get("features");
        System.out.println(features);
       // HashMap featuresMap = JSONObject.parseObject(features, HashMap.class); 报错的


    }


    /**
     * 测试一下jsonObejct
     */
    @Test
    public void test3() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "张三");
        jsonObject.put("id", "1");
        System.out.println(jsonObject.toString());
    }

    @Test
    public void test2() {
        String s = "";
        String s1 = JSON.toJSONString(null);
        TestJson testJson = JSONObject.parseObject(null, TestJson.class);
        System.out.println(testJson);
        System.out.println(s1);
    }

    @Test
    public void test1() {
        String s = "";

        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(s);
        System.out.println(map);
        Map<String, Object> formDataMap = (Map<String, Object>) JSONObject.parse(map.get("formData").toString());
        System.out.println(formDataMap);
    }


    @Test
    public void test() {
        String s = "{\n" +
                "\"rsj2XY710Request\": {\n" +
                "\"fhndText\": \"2020\",\n" +
                "\"xyjf\": \"12\",\n" +
                "\"yydm\": \"2\",\n" +
                "\"data\": {\n" +
                "\"title\": \"申请原因\",\n" +
                "\"name\": \"yydm\",\n" +
                "\"value\": \"\",\n" +
                "\"type\": \"select\",\n" +
                "\"validate\": {\n" +
                "\"required\": true\n" +
                "},\n" +
                "\"disabled\": false,\n" +
                "\"dataSet\": [{\n" +
                "\"ID\": \"\",\n" +
                "\"MC\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"ID\": \"1\",\n" +
                "\"MC\": \"对积分事项有异议\"\n" +
                "},\n" +
                "{\n" +
                "\"ID\": \"2\",\n" +
                "\"MC\": \"其他\"\n" +
                "}],\n" +
                "\"extraDisabled\": false\n" +
                "},\n" +
                "\"getValidator\": {\n" +
                "\"flag\": true,\n" +
                "\"tip\": \"\"\n" +
                "},\n" +
                "\"xxqksm\": \"XXXXX\",\n" +
                "\"zgswjg\": \"原河北省无极县国家税务局稽查局局长室\",\n" +
                "\"shxydm\": \"930322320223009XYDM\",\n" +
                "\"sszyfwjgmc\": \"秦皇岛朗税务师事务所有限公司(09)\",\n" +
                "\"fhnd\": \"2020\",\n" +
                "\"jbrText\": \"刘强\",\n" +
                "\"jbr\": \"13113113113\",\n" +
                "\"yydmText\": \"其他\",\n" +
                "\"xwlist\": [],\n" +
                "\"key\": \"xxqksm\",\n" +
                "\"jbrdh\": \"13113113113\"\n" +
                "},\n" +
                "\"formData\": {\n" +
                "\"fhndText\": \"2020\",\n" +
                "\"xyjf\": \"12\",\n" +
                "\"yydm\": \"2\",\n" +
                "\"data\": {\n" +
                "\"title\": \"申请原因\",\n" +
                "\"name\": \"yydm\",\n" +
                "\"value\": \"\",\n" +
                "\"type\": \"select\",\n" +
                "\"validate\": {\n" +
                "\"required\": true\n" +
                "},\n" +
                "\"disabled\": false,\n" +
                "\"dataSet\": [{\n" +
                "\"ID\": \"\",\n" +
                "\"MC\": \"\"\n" +
                "},\n" +
                "{\n" +
                "\"ID\": \"1\",\n" +
                "\"MC\": \"对积分事项有异议\"\n" +
                "},\n" +
                "{\n" +
                "\"ID\": \"2\",\n" +
                "\"MC\": \"其他\"\n" +
                "}],\n" +
                "\"extraDisabled\": false\n" +
                "},\n" +
                "\"getValidator\": {\n" +
                "\"flag\": true,\n" +
                "\"tip\": \"\"\n" +
                "},\n" +
                "\"xxqksm\": \"\",\n" +
                "\"zgswjg\": \"原河北省无极县国家税务局稽查局局长室\",\n" +
                "\"shxydm\": \"930322320223009XYDM\",\n" +
                "\"sszyfwjgmc\": \"秦皇岛朗税务师事务所有限公司(09)\",\n" +
                "\"fhnd\": \"2020\",\n" +
                "\"jbrText\": \"刘强\",\n" +
                "\"jbr\": \"13113113113\",\n" +
                "\"yydmText\": \"其他\",\n" +
                "\"key\": \"yydm\",\n" +
                "\"jbrdh\": \"13113113113\"\n" +
                "},\n" +
                "\"formDataQt\": {\n" +
                "\"getValidator\": {\n" +
                "\"flag\": true,\n" +
                "\"tip\": \"\"\n" +
                "},\n" +
                "\"xxqksm\": \"XXXXX\",\n" +
                "\"key\": \"xxqksm\"\n" +
                "},\n" +
                "\"fbzlRequestParaVOs\": [{\n" +
                "\"swsxMxDmList\": [],\n" +
                "\"swsxDm\": \"500019\"\n" +
                "}],\n" +
                "\"blxx\": \"{\\\"slswjgMc\\\":\\\"国家税务总局新疆维吾尔自治区税务局\\\",\\\"slswjgDm\\\":\\\"16500000000\\\",\\\"slrDm\\\":\\\"Administrator\\\",\\\"slrq\\\":\\\"2020-06-17\\\"}\",\n" +
                "\"sqfhxwjllbDataSource\": []\n" +
                "}";

        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(s);
        System.out.println(map);
        Map<String, Object> formDataMap = (Map<String, Object>) JSONObject.parse(map.get("formData").toString());
        System.out.println(formDataMap);
    }
}

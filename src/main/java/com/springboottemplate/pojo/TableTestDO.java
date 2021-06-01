package com.springboottemplate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/28 14:48
 */
@Data
public class TableTestDO {
    private Integer id;
    private long sid;
    private String name;
    private String sex;
    private int age;
    private String job;
    private String phone;
    private String birthday;
    private java.sql.Timestamp birthdayTimestamp;
    private String birthdayTimestampFormatByMysql;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String birthdayTimestampFormatByJava;

}

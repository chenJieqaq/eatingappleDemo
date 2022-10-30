package com.eatingApple.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class userEntity {
    private Long id;
    private String name;
    private int age;
    private String sex;
    private String phone;
    private String city;
}

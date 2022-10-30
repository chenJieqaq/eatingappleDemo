package com.eatingApple.req;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserSaveReq {
    private Long id;
    private String name;
    private int age;
    private String sex;
    private String phone;
    private String city;
}

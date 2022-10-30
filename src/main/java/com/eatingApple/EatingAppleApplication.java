package com.eatingApple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/eatingApple/mapper")
public class EatingAppleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatingAppleApplication.class, args);
    }

}

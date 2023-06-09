package com.shuxi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @ClassName APIApplication.java
 * @Description TODO
 * @createTime 2021年05月21日 16:25:00
 */
@SpringBootApplication
@MapperScan("com.shuxi.mapper")
public class APIApplication {
    public static void main(String[] args) {
        SpringApplication.run(APIApplication.class);
    }
}

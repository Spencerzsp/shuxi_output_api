package com.shuxi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2021年05月21日 16:26:00
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String testIt(){
        return "success";
    }
}

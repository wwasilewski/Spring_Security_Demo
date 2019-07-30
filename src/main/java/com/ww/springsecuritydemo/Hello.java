package com.ww.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wojciech Wasilewski
 * @date Created on 30.07.2019
 */
@RestController
public class Hello {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        return "hello2";
    }
}

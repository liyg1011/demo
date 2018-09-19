package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Value("${com.demo.cc}")
    private String cc;
    @Value("${com.demo.test}")
    private String test;
    @Value("${com.demo.test1}")
    private String test1;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void test() {
        System.out.println("-----------------------");
        System.out.println(cc);
        System.out.println(test);
        System.out.println(test1);
        System.out.println("-----------------------");
    }

}

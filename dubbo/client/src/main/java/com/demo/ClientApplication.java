package com.demo;

import com.demo.example.HelloService;
import com.demo.speech.SpeechService;
import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;
import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

	@Reference(version = "1.0.0")
  	private HelloService demoService;
	@Reference
    private SpeechService speechService;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
    @PostConstruct
    public void init() {
    	String sayHello = demoService.sayHello("world");
    	System.err.println(sayHello);
    }

    @PostConstruct
    public void init1() {
        speechService.convert("hello world");
    }
}

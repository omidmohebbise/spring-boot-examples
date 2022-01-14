package com.omidmohebbise.todoapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.omidmohebbise.todoapp")
public class ToDoAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}
}

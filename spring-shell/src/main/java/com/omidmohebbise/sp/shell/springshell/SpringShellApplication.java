package com.omidmohebbise.sp.shell.springshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.EnableCommand;

@SpringBootApplication
@EnableCommand({Example.class})
public class SpringShellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShellApplication.class, args);
    }

    @Command(command = "example")
    public String example() {
        return "Hello";
    }

}

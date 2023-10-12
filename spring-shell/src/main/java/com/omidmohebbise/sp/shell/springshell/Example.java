package com.omidmohebbise.sp.shell.springshell;


import org.springframework.shell.command.annotation.Command;

@Command
public class Example {
    @Command(command = "example")
    public String example() {
        return "Hello";
    }
}

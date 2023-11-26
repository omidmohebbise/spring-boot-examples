package com.omidmohebbise.integration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ComponentStarter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
//        AbstractApplicationContext context
//                = new AnnotationConfigApplicationContext(BasicIntegrationConfig.class);
//        context.registerShutdownHook();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Please enter q and press <enter> to exit the program: ");
//
//        while (true) {
//            String input = scanner.nextLine();
//            if("q".equals(input.trim())) {
//                break;
//            }
//        }
//        System.exit(0);
    }
}

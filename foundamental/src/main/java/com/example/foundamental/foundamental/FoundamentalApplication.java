package com.example.foundamental.foundamental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FoundamentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundamentalApplication.class, args);
    }

    @RestController
    public class TestController {
        @Autowired
        MessageSource messageSource;

        @GetMapping("/messages")
        public String method(){

            String msg= messageSource.getMessage("test.key",
                    null, LocaleContextHolder.getLocale());
            return msg;
        }
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages_foundamental");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}

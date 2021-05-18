package com.example.zullserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;



@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZullServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZullServerApplication.class, args);
    }
    @Bean
    public FirstFilter customZuulFilter() {
        return new FirstFilter();
    }
}

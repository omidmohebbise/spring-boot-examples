package com.omidmohebbise.springapachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/omidmohebbi/workspace/spring-boot-examples/spring-apache-camel/temp1?noop=true")
                .to("file:/Users/omidmohebbi/workspace/spring-boot-examples/spring-apache-camel/temp2");
    }


}

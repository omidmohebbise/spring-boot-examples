package com.omidmohebbise.springapachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // Define a route that fetches data from the remote API and exposes it locally.
        restConfiguration().component("servlet").port(9090)
                .host("localhost").bindingMode(RestBindingMode.json);

//      rest("http4:https://dummy.restapiexample.com/api/v1/employees")
//              .get()
//              .to("servlet:///localhost:9090/employees"); // Expose as a local REST endpoint

//        rest().get("/hello").produces(MediaType.APPLICATION_JSON_VALUE)


//        from("direct:getRemoteData")
//                .to("rest:get:https://dummy.restapiexample.com/api/v1/employees?bridgeEndpoint=true")
//                .to("servlet:///local-api/employees"); // Expose as a local REST endpoint

        // You can define additional routes or custom data transformation here.
    }

}

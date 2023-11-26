package com.omidmohebbise.springapachecamel;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Rest2SoapExample extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Read data from a REST API endpoint
        from("rest:https://dummy.restapiexample.com/api/v1/employees")
                .setBody(constant("<response>This is your REST response</response>"))
                .to("direct:transformToSoap");

        // Transform the data to a SOAP response
        from("direct:transformToSoap")
                .setHeader("Content-Type", constant("text/xml"))
                .transform(body().regexReplaceAll("<response>", "<soapResponse>").regexReplaceAll("</response>", "</soapResponse>"));

        // Expose the data as a SOAP web service
        from("jetty:http://localhost:9090/soap/data")
                .to("direct:transformToSoap");
    }
}


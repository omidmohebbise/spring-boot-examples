package com.swagger.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class SimpleController {


    @PostMapping({"hello"})
    public String getHelloWorld(@RequestBody(required = true) Person person) {
        System.out.println("Person Info = " + person);

        return person.toString();
    }

    @PostMapping({"/hello1"})
    public HashMap<String, Object> simplePost(@ApiParam(value = "json", required = true,
            defaultValue = "1",
            name = "json",
            examples = @Example({@ExampleProperty("{\"id\": \"1\",\"deviceToken\":\"1\"}")})) @RequestBody HashMap<String, Object> json,
                                              @ApiParam(name = "securityToken", value = "securityToken", defaultValue = "7d0fcbca-d6f0-4f29-b19f-2f8fe4e0f730") @RequestHeader String securityToken,
                                              @ApiParam(name = "userId", value = "userId", defaultValue = "1") @RequestHeader String userId) {
        return null;

    }

}

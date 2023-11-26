package com.omidmohebbise.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IntegrationController {

    private final MessageChannel requestChannel1;

    @GetMapping("/forwardRequest/{id}")
    public String forwardRequest(@PathVariable String id) {
        // Create a message and send it to the requestChannel
        Message<String> message = MessageBuilder.withPayload(id).build();
        requestChannel1.send(message);

        // You can return a response or handle it as needed
        return "Request forwarded to external service";
    }
}

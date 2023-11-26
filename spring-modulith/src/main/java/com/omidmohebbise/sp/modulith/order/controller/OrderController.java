package com.omidmohebbise.sp.modulith.order.controller;


import com.omidmohebbise.sp.modulith.order.service.OrderService;
import com.omidmohebbise.sp.modulith.order.service.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO newOrder) {
        return ResponseEntity.ok(orderService.addOrder(newOrder).getId());
    }
}

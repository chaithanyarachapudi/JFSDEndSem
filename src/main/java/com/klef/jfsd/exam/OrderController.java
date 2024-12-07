package com.klef.jfsd.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        if (order.getOrderId() == null || order.getOrderId().isEmpty()) {
            return new ResponseEntity<>("Order ID must not be null or empty", HttpStatus.BAD_REQUEST);
        }
        orderService.addOrder(order);
        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }
}
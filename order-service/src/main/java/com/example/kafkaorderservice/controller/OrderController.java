package com.example.kafkaorderservice.controller;

import com.example.kafkaorderservice.model.dto.OrderEventDto;
import com.example.kafkaorderservice.service.impl.OrderEventPublisherServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderEventPublisherServiceImpl orderEventPublisherService;

    public OrderController(OrderEventPublisherServiceImpl orderEventPublisherService) {
        this.orderEventPublisherService = orderEventPublisherService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderEventDto orderDto) {
        orderEventPublisherService.publishOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

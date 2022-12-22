package com.example.kafkaorderservice.service;

import com.example.kafkaorderservice.model.dto.OrderEventDto;

public interface OrderEventPublisherService {

    void publishOrder(OrderEventDto orderDto);
}

package com.example.kafkaorderservice.service.impl;

import com.example.kafkaorderservice.model.dto.OrderEventDto;
import com.example.kafkaorderservice.service.OrderEventPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEventPublisherServiceImpl implements OrderEventPublisherService {

    private final KafkaTemplate<String, OrderEventDto> kafkaTemplate;

    public OrderEventPublisherServiceImpl(KafkaTemplate<String, OrderEventDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishOrder(OrderEventDto orderEventDto) {
        log.info(String.format("Publishing Event OrderEventDTO: %s", orderEventDto));
        ProducerRecord<String, OrderEventDto> producerRecord = new ProducerRecord<>("ORDER_PENDING", null, orderEventDto);
        kafkaTemplate.send(producerRecord);
    }
}

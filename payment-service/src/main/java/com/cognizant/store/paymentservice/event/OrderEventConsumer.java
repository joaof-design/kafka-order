package com.cognizant.store.paymentservice.event;

import com.cognizant.store.paymentservice.model.dto.OrderEventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventConsumer {

    @KafkaListener(topics = {"ORDER_PENDING"}, groupId = "PaymentModule", containerFactory = "kafkaListenerContainerFactory")
    public void receive(OrderEventDto orderEventDto) {
        log.info(String.format("Received message OrderEventDTO: %s", orderEventDto));
    }
}
package com.cognizant.store.paymentservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderEventDto {

    private Long orderId;
    private Long clientId;
    private Double price;
}

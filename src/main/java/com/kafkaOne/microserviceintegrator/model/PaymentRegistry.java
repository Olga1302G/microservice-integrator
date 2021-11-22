package com.kafkaOne.microserviceintegrator.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaymentRegistry {
    private Long id;

    private Long paymentId;

    private String date;

    private String amount;
    public PaymentRegistry(String date, String amount){
        this.date = date;
        this.amount = amount;
    }

    }

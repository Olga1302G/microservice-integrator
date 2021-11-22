package com.kafkaOne.microserviceintegrator.service;

import com.kafkaOne.microserviceintegrator.dto.PaymentDto;
import com.kafkaOne.microserviceintegrator.model.PaymentAll;


public interface PaymentDtoService {
    void consume(PaymentDto paymentDto);
    void produce(PaymentAll paymentAll);
    PaymentAll createPaymentAll();
}

package com.kafkaOne.microserviceintegrator.service;


import com.kafkaOne.microserviceintegrator.dto.ResponseDto;
import com.kafkaOne.microserviceintegrator.model.PaymentRegistry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "microservice-registry", url = "http://localhost:8103/payments")
public interface PaymentFeignClient {
    @GetMapping("/{paymentId}")
    public ResponseEntity<ResponseDto> getPayment(@PathVariable Long paymentId);
}

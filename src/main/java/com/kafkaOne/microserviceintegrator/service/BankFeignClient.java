package com.kafkaOne.microserviceintegrator.service;

import com.kafkaOne.microserviceintegrator.model.BankClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "microservice-bank", url = "http://localhost:8101/banks")
public interface BankFeignClient {
    @GetMapping("/{clientId}")
    public ResponseEntity<BankClient> getClient(@PathVariable Long clientId);

}

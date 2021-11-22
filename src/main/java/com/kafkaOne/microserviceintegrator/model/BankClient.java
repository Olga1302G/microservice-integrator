package com.kafkaOne.microserviceintegrator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankClient {

    private Long clientId;

    private Long paymentId;

    private String name;

    private String city;

    private String created;
}

package com.kafkaOne.microserviceintegrator.model;

import com.kafkaOne.microserviceintegrator.dto.RegistryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentAll implements Serializable {
    private Long clientId;

    private Long paymentId;

    private String name;

    private String city;

    private String created;

    private String amount;

    private List<RegistryDto> history;

}

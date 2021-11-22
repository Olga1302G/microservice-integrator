package com.kafkaOne.microserviceintegrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistryDto {

    private String date;

    private String amount;
}

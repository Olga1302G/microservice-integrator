package com.kafkaOne.microserviceintegrator.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto implements Serializable {
     @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long clientId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer amount;
}

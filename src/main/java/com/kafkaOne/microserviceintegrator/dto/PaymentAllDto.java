package com.kafkaOne.microserviceintegrator.dto;

import com.kafkaOne.microserviceintegrator.model.BankClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAllDto {
    private BankClient bankClient;
    private Integer amount;
    private ResponseDto responseDto;
}

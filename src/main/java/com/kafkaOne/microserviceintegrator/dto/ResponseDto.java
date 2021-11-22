package com.kafkaOne.microserviceintegrator.dto;

import com.kafkaOne.microserviceintegrator.model.BankClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
        private Long paymentId;
        private List<RegistryDto> history;
}

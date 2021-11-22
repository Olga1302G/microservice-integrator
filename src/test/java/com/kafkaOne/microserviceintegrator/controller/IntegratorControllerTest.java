package com.kafkaOne.microserviceintegrator.controller;

import com.google.gson.Gson;
import com.kafkaOne.microserviceintegrator.dto.RegistryDto;
import com.kafkaOne.microserviceintegrator.model.PaymentAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class IntegratorControllerTest {

    @Autowired
    IntegratorController integratorController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testExistence() throws Exception {
        assertNotNull(integratorController, "Integrator Rest controller is null");
    }

    @Test
    public String getPaymentAll() throws Exception {
        List<RegistryDto> history = new ArrayList<>();
        history.add(new RegistryDto("12.10.2020", "1200"));
        history.add(new RegistryDto("11.12.2020", "23000"));
        String paymentAllJson = new Gson().toJson(PaymentAll.builder()
                .clientId(1L)
                .paymentId(1L)
                .amount("1800")
                .city("Omsk")
                .created("12.08.1999")
                .history(history)
                .build());
        mockMvc.perform(get("/integrator"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(paymentAllJson));
        return paymentAllJson;
    }

}
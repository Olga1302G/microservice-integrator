package com.kafkaOne.microserviceintegrator.controller;



import com.kafkaOne.microserviceintegrator.model.PaymentAll;

import com.kafkaOne.microserviceintegrator.service.PaymentDtoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/integrator")
@Api(value = "hello")
public class IntegratorController {

    private PaymentDtoService paymentDtoService;


    public IntegratorController(PaymentDtoService paymentDtoService){
        this.paymentDtoService = paymentDtoService;
    }

    @GetMapping
    @ApiOperation(" Получение данных о клиенте через Spring Cloud OpenFeign и отправка в integration-test")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение информации о клиенте и суммах платежей"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public String getPaymentAll(){
        PaymentAll paymentAll = paymentDtoService.createPaymentAll();
        paymentDtoService.produce(paymentAll);
        return paymentAll.toString();
    }


}

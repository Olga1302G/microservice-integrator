package com.kafkaOne.microserviceintegrator.service;


import com.kafkaOne.microserviceintegrator.dto.PaymentAllDto;
import com.kafkaOne.microserviceintegrator.dto.PaymentDto;

import com.kafkaOne.microserviceintegrator.dto.ResponseDto;
import com.kafkaOne.microserviceintegrator.model.BankClient;

import com.kafkaOne.microserviceintegrator.model.PaymentAll;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class PaymentDtoServiceImpl implements PaymentDtoService {

    private BankFeignClient bankFeignClient;
    private PaymentFeignClient paymentFeignClient;
    private KafkaTemplate<String, PaymentAll> kafkaTemplate;
    private MapperFacade facade;

    private Long clientId;
    private Integer amount1;


    @Autowired
    public PaymentDtoServiceImpl(BankFeignClient bankFeignClient,
                                 PaymentFeignClient paymentFeignClient,
                                 MapperFacade facade, KafkaTemplate<String, PaymentAll> kafkaTemplate) {
        this.bankFeignClient = bankFeignClient;
        this.paymentFeignClient = paymentFeignClient;
        this.facade = facade;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produce(PaymentAll paymentAll) {
        System.out.println("Producing the message: " + paymentAll);
        kafkaTemplate.send("server.test", paymentAll);
    }

    @Override
    @KafkaListener(id = "Payment", topics = {"server.payment"}, containerFactory = "singleFactory")
    public void consume(PaymentDto paymentDto) {
        log.info("=> consumed {}", paymentDto);
        clientId = paymentDto.getClientId();
        amount1 = paymentDto.getAmount();
    }

    public PaymentAll createPaymentAll() {
        BankClient bankClient = bankFeignClient.getClient(clientId).getBody();
        ResponseDto response = paymentFeignClient.getPayment(bankClient.getPaymentId()).getBody();
        Integer amount = amount1;
        PaymentAllDto paymentAllDto = new PaymentAllDto(bankClient, amount, response);
        PaymentAll paymentAll = facade.map(paymentAllDto, PaymentAll.class);
        return paymentAll;
    }

    public BankClient getClient(Long id) {
        BankClient bankClient = bankFeignClient.getClient(id).getBody();
        return bankClient;
    }

    public ResponseDto getPayment(Long id) {
        return paymentFeignClient.getPayment(id).getBody();
    }


}

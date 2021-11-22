package com.kafkaOne.microserviceintegrator;


import com.kafkaOne.microserviceintegrator.dto.PaymentAllDto;

import com.kafkaOne.microserviceintegrator.model.PaymentAll;
import lombok.Getter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class ModelMapper extends ConfigurableMapper {
    @Getter
    private MapperFactory mapperFactory;

    @Override
    protected void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);
        this.mapperFactory = mapperFactory;
        mapperFactory.classMap(PaymentAllDto.class, PaymentAll.class)
                .field("bankClient.clientId", "clientId")
                .field("bankClient.paymentId", "paymentId")
                .field("bankClient.name", "name")
                .field("bankClient.city", "city")
                .field("bankClient.created", "created")
                .field("amount", "amount")
                .field("responseDto.history", "history")
                .byDefault()
                .register();

    }

}

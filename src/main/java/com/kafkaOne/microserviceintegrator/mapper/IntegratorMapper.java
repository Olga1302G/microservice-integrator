package com.kafkaOne.microserviceintegrator.mapper;

import com.kafkaOne.microserviceintegrator.ModelMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegratorMapper {
    @Bean
    public MapperFacade mapperFacade(){
        MapperFacade facade = new ModelMapper();
        return facade;
    }
}

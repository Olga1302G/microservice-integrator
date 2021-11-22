package com.kafkaOne.microserviceintegrator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@SpringBootApplication
@EnableKafka
@EnableEurekaServer
@EnableFeignClients
@PropertySource({
		"classpath:kafka.properties"
})
public class MicroserviceIntegratorApplication {



	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(MicroserviceIntegratorApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
	@Bean
	public JsonDeserializer jsonDeserializer() {
		return new JsonDeserializer() {
			@Override
			public Object deserialize(JsonParser p, DeserializationContext context) throws IOException {
				return null;
			}
		};
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}

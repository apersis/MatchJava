package com.cesi.match;

import com.cesi.match.utils.MapperMeetMeetDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean
	public MapperMeetMeetDTO mapperMeetMeetDTO() {
		return new MapperMeetMeetDTO();
	}

}
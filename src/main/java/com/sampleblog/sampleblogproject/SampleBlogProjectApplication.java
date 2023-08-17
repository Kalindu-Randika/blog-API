package com.sampleblog.sampleblogproject;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info (
				title = "Spring Boot Blog App REST API",
				description = "Spring Boot Blog App REST API Documentation",
				version = "V1.0",
				contact = @Contact(
						name = "Kalindu Randika",
						email = "kalindu.randika@gmail.com",
						url = "https://wwww.kalindu.me"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.kalindu.me"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Blog App Documentation",
				url = "https://github.com/Kalindu-Randika/blog-API"
		)
)



public class SampleBlogProjectApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleBlogProjectApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

	}
}

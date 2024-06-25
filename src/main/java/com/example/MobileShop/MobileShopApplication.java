package com.example.MobileShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MobileShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileShopApplication.class, args);
	}

}

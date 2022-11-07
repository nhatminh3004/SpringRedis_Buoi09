package com.example.rediscache_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RediscacheCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RediscacheCrudApplication.class, args);
	}

}

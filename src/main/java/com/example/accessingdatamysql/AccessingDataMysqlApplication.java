package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Entry point
@SpringBootApplication() // This annotation can be used to enable three features:
// @EnableAutoConfiguration: enable Spring boot's auto configuration mechanism (https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-auto-configuration.html)
// @ComponentScan: enable @Component scan on the package where the application is located (Best practices structuring your code: https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-structuring-your-code.html)
// @Configuration: allow to register extra beans in the context or import additional configuration classes
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}

}

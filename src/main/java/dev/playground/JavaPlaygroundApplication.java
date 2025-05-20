package dev.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JavaPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaPlaygroundApplication.class, args);
	}

}

package com.simba.obd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationPropertiesConfig.class})
public class ObdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObdApplication.class, args);
	}

}

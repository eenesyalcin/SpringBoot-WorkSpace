package com.enesyalcin.starter;

import com.enesyalcin.configuration.GlobalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.enesyalcin"})
@ComponentScan(basePackages = {"com.enesyalcin"})
@EnableJpaRepositories(basePackages = {"com.enesyalcin"})
@SpringBootApplication
@PropertySource(value = "classpath:app.properties")
@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}

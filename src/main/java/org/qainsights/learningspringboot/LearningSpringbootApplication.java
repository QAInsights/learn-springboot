package org.qainsights.learningspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearningSpringbootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LearningSpringbootApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(LearningSpringbootApplication.class, args);
		var contextBean = context.getBean(OrderService.class);
		contextBean.processOrder(123);
		context.close();


	}

}

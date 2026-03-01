package org.qainsights.learningspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearningSpringbootApplication {

	public static void main(String[] args) throws IllegalAccessException {
//		SpringApplication.run(LearningSpringbootApplication.class, args);

//		ConfigurableApplicationContext context = SpringApplication.run(LearningSpringbootApplication.class, args);
//		var contextBean = context.getBean(OrderService.class);
//		contextBean.processOrder(123);
//		context.close();

		ApplicationContext context = SpringApplication.run(LearningSpringbootApplication.class, args);
		var userBean = context.getBean(UserService.class);
		userBean.registerUser(new User(2L, "test@example.com", "password", "Test User"));
		userBean.registerUser(new User(1L, "test@example.com", "password", "Test User"));

	}

}

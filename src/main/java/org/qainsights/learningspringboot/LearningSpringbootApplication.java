package org.qainsights.learningspringboot;

import org.apache.logging.log4j.util.ProcessIdUtil;
import org.qainsights.learningspringboot.entities.Address;
import org.qainsights.learningspringboot.entities.Profile;
import org.qainsights.learningspringboot.entities.Tag;
import org.qainsights.learningspringboot.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class LearningSpringbootApplication {

	public static void main(String[] args) throws IllegalAccessException {
//		SpringApplication.run(LearningSpringbootApplication.class, args);

//		ConfigurableApplicationContext context = SpringApplication.run(LearningSpringbootApplication.class, args);
//		var contextBean = context.getBean(OrderService.class);
//		contextBean.processOrder(123);
//		context.close();

		var user = User.builder()
				.name("naveenkumar")
				.password("test1234")
				.email("n@n.com")
				.build();

//		var address = Address.builder()
//				.street("123 Main Rd")
//				.city("Testville")
//				.zip("12323")
//				.state("NN")
//				.build();
//
//		user.addAddress(address);

//		user.addTag("tag1");

		var profile = Profile.builder()
				.bio("test")
				.phoneNumber("12212")
				.dateOfBirth(LocalDate.now())
				.loyaltyPoints(11L)
				.build();

		user.setProfile(profile);


		System.out.println(user);


//		ApplicationContext context = SpringApplication.run(LearningSpringbootApplication.class, args);
//		var userBean = context.getBean(UserService.class);
//		userBean.registerUser(new User(2L, "test@example.com", "password", "Test User"));
//		userBean.registerUser(new User(1L, "test@example.com", "password", "Test User"));

	}

}

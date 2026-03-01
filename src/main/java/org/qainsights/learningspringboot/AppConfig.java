package org.qainsights.learningspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${payment.choice:${payment.default}}")
    private String defaultPayment;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }


    @Bean
    public OrderService orderService() {
        if(defaultPayment.equals("stripe")) {
            return new OrderService(stripe());
        }
        else if(defaultPayment.equals("paypal")) {
            return new OrderService(paypal());
        }
        return new OrderService(paypal());
    }
}

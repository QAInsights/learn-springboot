package org.qainsights.learningspringboot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostConstruct
    public void init() {
        System.out.println("OrderService init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("OrderService destroy");
    }

    public void processOrder(double amount){
        paymentService.processPayment(amount);
    }
}

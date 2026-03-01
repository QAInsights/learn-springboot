package org.qainsights.learningspringboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@Qualifier("stripe")
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl:https://test.stripe.com}")
    private String apiUrl;

    @Value("${stripe.enabled:false}")
    private boolean stripeEnabled;

    @Value("${stripe.currencies:INR}")
    private String currencies;

    @Value("${stripe.version:1.0.0}")
    private String version;

    @Value("${stripe.products}")
    private List<String> products;

    @Override
    public void processPayment(double amount) {

        if (stripeEnabled) {
            System.out.println("StripePaymentService using Stripe API");
            System.out.println("StripePaymentService: " + amount);
            System.out.println("Using the API url: " + apiUrl);
            System.out.println("Stripe Currencies: " + currencies);
            System.out.println("Stripe version: " + version);
            System.out.println("Stripe products: " + products);
        }

    }
}

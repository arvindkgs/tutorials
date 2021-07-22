package com.baeldung.hexagonal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.baeldung.hexagonal.domain.BillingHandler;
import com.baeldung.hexagonal.domain.Order;
import com.baeldung.hexagonal.exception.PaymentException;
import com.stripe.exception.StripeException;

public class BillingController {

    private final BillingHandler billingHandler;

    public BillingController(BillingHandler billingHandler) {
        this.billingHandler = billingHandler;
    }

    @PostMapping(path = "/pay")
    public ResponseEntity<Integer> pay(@RequestBody Order order) throws PaymentException, StripeException {
        return ResponseEntity.ok(billingHandler.pay(order));
    }
}

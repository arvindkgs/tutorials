package com.baeldung.hexagonal.domain;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;

import com.baeldung.hexagonal.exception.PaymentException;
import com.baeldung.hexagonal.service.PaymentService;
import com.stripe.exception.StripeException;

public class BillingHandlerTest {

    private PaymentService mockPay;

    @Before
    void setup() {
        mockPay = Mockito.mock(PaymentService.class);
    }

    public void whenPay_thenSuccess() throws PaymentException, StripeException {
        Mockito.when(mockPay.debit(Mockito.any()))
            .then(x -> 100);

        BillingHandler billing = new BillingHandler(mockPay);
        Order singleOrder = new Order();
        singleOrder.getItems()
          .add(new Item(100, 1));
        Assert.assertEquals(100, billing.pay(singleOrder));
    }

}

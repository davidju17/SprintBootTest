package com.davidmonroy.springbootlibrary.controller;


import com.davidmonroy.springbootlibrary.requestmodels.PaymentInfoRequest;
import com.davidmonroy.springbootlibrary.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/payment/secure")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@AuthenticationPrincipal Jwt jwt,
                                                      @RequestBody PaymentInfoRequest paymentInfoRequest)
            throws StripeException {

        PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfoRequest);
        String paymentStr = paymentIntent.toJson();

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }

    @PutMapping("/payment-complete")
    public ResponseEntity<String> stripePaymentComplete(@AuthenticationPrincipal Jwt jwt)
            throws Exception {
        String userEmail = jwt.getClaim("email");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return paymentService.stripePayment(userEmail);
    }
}



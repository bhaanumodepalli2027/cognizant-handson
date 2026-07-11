package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/loans/{number}")
    public Loan getLoanDetails(@PathVariable String number) {
        LOGGER.info("START - Fetching loan details for loan number: {}", number);

        // Mocked response payload matching lab specifications
        Loan mockLoan = new Loan("H00987987972342", "car", 400000, 3258, 18);

        LOGGER.info("END - Returning mock data for loan: {}", mockLoan.getNumber());
        return mockLoan;
    }
}
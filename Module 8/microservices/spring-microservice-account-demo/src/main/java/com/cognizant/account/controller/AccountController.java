package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts/{number}")
    public Account getAccountDetails(@PathVariable String number) {
        LOGGER.info("START - Fetching account details for account number: {}", number);

        // Mocked response payload matching lab specifications
        Account mockAccount = new Account("00987987973432", "savings", 234343);

        LOGGER.info("END - Returning mock data for account: {}", mockAccount.getNumber());
        return mockAccount;
    }
}
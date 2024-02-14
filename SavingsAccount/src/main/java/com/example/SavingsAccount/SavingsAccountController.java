package com.example.SavingsAccount;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/account")
public class SavingsAccountController {

    private int balance;

    @GetMapping("/balance")
    public String getBalance() {
        return "Your balance is $" + balance;
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return "You just withdrew $" + amount + ". New balance: $" + balance;
        } else {
            return "Invalid withdrawal amount or insufficient funds.";
        }
    }

    @PostMapping("/deposit")
    public String deposit(@RequestBody int amount) {
        if (amount > 0) {
            balance += amount;
            return "You just deposited $" + amount + ". New balance: $" + balance;
        } else {
            return "Invalid deposit amount.";
        }
    }
}

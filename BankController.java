package com.example.demo.controller;

import com.example.demo.entity.BankAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    List<BankAccount> bankAccountList = new ArrayList<BankAccount>();

    public BankController() {
        bankAccountList.add(new BankAccount(101,"Jack",500000));
        bankAccountList.add(new BankAccount(102,"Jane",600000));
        bankAccountList.add(new BankAccount(103,"Janet",700000));
        bankAccountList.add(new BankAccount(104,"Smith",800000));
        bankAccountList.add(new BankAccount(105,"Neo",900000));

    }
    @GetMapping
    public String home() {
        return "<h1>Welcome to My Bank</h1>";
    }

    @GetMapping("/accounts")
    public List<BankAccount> all() {
        return bankAccountList;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<?> getOneAccount(@PathVariable String id ) {
        BankAccount bankAccountFound = null;
        boolean found = false;

        int idToSearch = Integer.parseInt(id);
        for (BankAccount bankAccount : bankAccountList) {
            if(idToSearch == bankAccount.getAccountNumber()) {
                bankAccountFound = bankAccount;
                found=true;
                break;
            }
        }
        if(found) {
            return ResponseEntity.ok(bankAccountFound);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}

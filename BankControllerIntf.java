package com.example.demo.controller;

import com.example.demo.entity.BankAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BankControllerIntf {
    public List<BankAccount> all();
    public ResponseEntity<?> getOneAccount(String id);
    public ResponseEntity<?> addOneAccount(@RequestBody BankAccount bankAccount );
    public ResponseEntity<?> updateOneAccount(@RequestBody BankAccount bankAccount );
    public ResponseEntity<?> deleteOneAccount(String id);

}
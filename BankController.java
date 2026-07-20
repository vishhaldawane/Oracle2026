package com.example.demo.controller;

import com.example.demo.entity.BankAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            //return ResponseEntity.notFound().build();
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: The account number " + id + " does not exist");
        }

      //  return userService.findById(id)
       //         .orElseThrow(() ->
         //               new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    }

    @PostMapping("/account/add")
    public ResponseEntity<?> addOneAccount(@RequestBody BankAccount bankAccount ) {
        BankAccount bankAccountFound = null;
        boolean found = false;

        int idToSearch = bankAccount.getAccountNumber();

        for (BankAccount bankAccountObj : bankAccountList) {
            if(idToSearch == bankAccountObj.getAccountNumber()) {
                found=true;
                break;
            }
        }
        if(found) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: The account number " + bankAccount.getAccountNumber() + " already exist");

        }else {
            //return ResponseEntity.notFound().build();
            bankAccountList.add(bankAccount);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("The account number " + bankAccount.getAccountNumber()+ " created");

        }


    }

    @PutMapping("/account/update")
    public ResponseEntity<?> updateOneAccount(@RequestBody BankAccount bankAccount ) {
        BankAccount bankAccountFound = null;
        boolean found = false;

        int idToSearch = bankAccount.getAccountNumber();

        for (BankAccount bankAccountObj : bankAccountList) {
            if(idToSearch == bankAccountObj.getAccountNumber()) {
                bankAccountFound = bankAccountObj;
                found=true;
                break;
            }
        }
        if(found) {
            bankAccountList.remove(bankAccountFound);
            bankAccountList.add(bankAccount);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("The account object " + bankAccount.getAccountNumber()+ " updated");

        }else {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: The account number " + bankAccount.getAccountNumber() + " does not exist");

            //return ResponseEntity.notFound().build();

        }



    }


    @DeleteMapping("/account/delete/{id}")
    public ResponseEntity<?> updateOneAccount(@PathVariable String id ) {
        BankAccount bankAccountFound = null;
        boolean found = false;

        int idToSearch = Integer.parseInt(id);

        for (BankAccount bankAccountObj : bankAccountList) {
            if (idToSearch == bankAccountObj.getAccountNumber()) {
                bankAccountFound = bankAccountObj;
                found = true;
                break;
            }
        }
        if (found) {
            bankAccountList.remove(bankAccountFound);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("The account object " + idToSearch + " removed");

        } else {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: The account number " + idToSearch + " does not exist");

            //return ResponseEntity.notFound().build();

        }
    }
}

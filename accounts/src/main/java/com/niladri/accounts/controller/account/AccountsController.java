package com.niladri.accounts.controller.account;

import com.niladri.accounts.dto.account.AccountDto;
import com.niladri.accounts.dto.customer.CustomerDto;
import com.niladri.accounts.model.customer.CustomerModel;
import com.niladri.accounts.services.account.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/accounts",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsController {

    private AccountService accountService;

    @PostMapping(value = "/create")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody CustomerModel customerDetails){
        AccountDto accountDto = accountService.createAccount(customerDetails);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping(value = "/get/{accountNumber}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable Long accountNumber){
        AccountDto accountDto = accountService.getAccountDetails(accountNumber);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping(value = "/update/{accountNumber}")
    public ResponseEntity<AccountDto> updateAccountDetails(@PathVariable Long accountNumber, @Valid @RequestBody AccountDto accountDetails){
        AccountDto accountDto = accountService.updateAccountDetails(accountNumber, accountDetails);
        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping(value = "/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.ok("Account deleted successfully");
    }
}

package com.niladri.accounts.controller.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niladri.accounts.dto.AccountsContactInfoDto;
import com.niladri.accounts.dto.account.AccountDto;
import com.niladri.accounts.dto.common.ErrorResponseDto;
import com.niladri.accounts.model.customer.CustomerModel;
import com.niladri.accounts.services.account.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Tag(name = "CRUD Accounts API", description = "Accounts API for managing customer accounts")
@RestController
@RequestMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class AccountsController {


    private final AccountService accountService;

    private final AccountsContactInfoDto accountsContactInfoDto;

    @Value("${build.version}")
    private String buildVersion;



    @Operation(
            summary = "Get API version",
            description = "Get the version of the API"
    )
    @GetMapping(value = "/build-version")
    public ResponseEntity<String> getApiVersion() {
        return ResponseEntity.ok("API version: " + buildVersion);
    }



    @Operation(
            summary = "Create a new account for a customer",
            description = "Create a new account for a customer with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Account created successfully")
    @PostMapping(value = "/create")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody CustomerModel customerDetails) {
        AccountDto accountDto = accountService.createAccount(customerDetails);
        return ResponseEntity.ok(accountDto);
    }


    @Operation(
            summary = "Get account details",
            description = "Get account details for the provided account number"
    )
    @ApiResponse(responseCode = "200", description = "Account details retrieved successfully")
    @GetMapping(value = "/get/{accountNumber}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable Long accountNumber) {
        AccountDto accountDto = accountService.getAccountDetails(accountNumber);
        return ResponseEntity.ok(accountDto);
    }


    @Operation(
            summary = "Update account details",
            description = "Update account details for the provided account number"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account details updated successfully"),
            @ApiResponse(responseCode = "417", description = "Update operation failed. Please try again or contact Dev team",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    @PutMapping(value = "/update/{accountNumber}")
    public ResponseEntity<AccountDto> updateAccountDetails(@PathVariable Long accountNumber, @Valid @RequestBody AccountDto accountDetails) {
        AccountDto accountDto = accountService.updateAccountDetails(accountNumber, accountDetails);
        return ResponseEntity.ok(accountDto);
    }


    @Operation(
            summary = "Delete account",
            description = "Delete account for the provided account number"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
            @ApiResponse(responseCode = "417", description = "Delete operation failed. Please try again or contact Dev team")
    })
    @DeleteMapping(value = "/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.ok("Account deleted successfully");
    }

    @Operation(
            summary = "Get contact information",
            description = "Get contact information for the accounts API"
    )
    @GetMapping(value = "/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo() {
        return ResponseEntity.ok(accountsContactInfoDto);
    }
}

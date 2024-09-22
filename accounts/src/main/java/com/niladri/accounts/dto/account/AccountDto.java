package com.niladri.accounts.dto.account;

import com.niladri.accounts.dto.customer.CustomerDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountDto {

    @NotNull(message = "Account number is mandatory")
    private Long accountNumber;
    @NotEmpty(message = "Account type is mandatory")
    private String accountType;
    @NotEmpty(message = "Branch address is mandatory")
    private String branchAddress;

    private Long customerId;

    private CustomerDto customerDetails;
}

package com.niladri.accounts.dto.customer;

import com.niladri.accounts.dto.account.AccountDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

//    @NotNull(message = "Customer id is mandatory")
    private Long customerId;

    @NotBlank
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
    private String customerName;

    @NotBlank
    @Size(min = 3, max = 50, message = "Customer email must be between 3 and 50 characters")
    private String customerEmail;

    @NotBlank
    @Size(min = 10, max = 10, message = "Customer phone must be 10 characters")
    private String customerPhone;

//    private AccountDto accountDetails;
}

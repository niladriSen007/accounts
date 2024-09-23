package com.niladri.accounts.dto.account;

import com.niladri.accounts.dto.customer.CustomerDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name = "Account", description = "Account details")
@Data
public class AccountDto {

    @Schema(description = "Account number", example = "1234567890")
    @NotNull(message = "Account number is mandatory")
    private Long accountNumber;

    @Schema(description = "Account type", example = "Savings")
    @NotEmpty(message = "Account type is mandatory")
    private String accountType;

    @Schema(description = "Branch name", example = "New York")
    @NotEmpty(message = "Branch address is mandatory")
    private String branchAddress;

    private Long customerId;

    private CustomerDto customerDetails;
}

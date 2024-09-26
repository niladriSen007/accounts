package com.niladri.accounts.dto.customer;

import com.niladri.accounts.dto.account.AccountDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Customer details")
public class CustomerDto {

//    @NotNull(message = "Customer id is mandatory")
    private Long customerId;


    @Schema(description = "Customer name", example = "John Doe")
    @NotBlank(message = "Customer name is mandatory")
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
    private String customerName;


    @Schema(description = "Customer email", example = "johndoe@gmail.com")
    @NotBlank(message = "Customer email is mandatory")
    @Size(min = 3, max = 50, message = "Customer email must be between 3 and 50 characters")
    @Email(message = "Customer email must be a valid email")
    private String customerEmail;


    @Schema(description = "Customer phone", example = "9876543210")
    @NotBlank(message = "Customer phone is mandatory")
    @Size(min = 10, max = 10, message = "Customer phone must be 10 characters")
    @Digits(integer = 10, fraction = 0, message = "Customer phone must be a valid number")
//    @Pattern(regexp = "^[0-9]{10}", message = "Customer phone must be a valid number")
    private String customerPhone;

//    private AccountDto accountDetails;
}

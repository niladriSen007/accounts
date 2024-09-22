package com.niladri.accounts.services.account;

import com.niladri.accounts.dto.account.AccountDto;
import com.niladri.accounts.dto.customer.CustomerDto;
import com.niladri.accounts.model.customer.CustomerModel;
import jakarta.validation.Valid;

public interface AccountServiceInterface {

    //    @param = CustomerDto object
    AccountDto createAccount(@Valid CustomerModel customerDetails);

    //    @param = accountNumber
    AccountDto getAccountDetails(Long accountNumber);

    AccountDto updateAccountDetails(Long accountNumber, @Valid AccountDto accountDetails);

    void deleteAccount(Long accountNumber);
}

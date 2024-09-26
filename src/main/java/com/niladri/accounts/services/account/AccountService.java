package com.niladri.accounts.services.account;

import com.niladri.accounts.constants.AccountConstants;
import com.niladri.accounts.dto.account.AccountDto;
import com.niladri.accounts.dto.customer.CustomerDto;
import com.niladri.accounts.exception.CustomerAlreadyExist;
import com.niladri.accounts.exception.ResourceNotFound;
import com.niladri.accounts.mapper.AccountMapper;
import com.niladri.accounts.mapper.CustomerMapper;
import com.niladri.accounts.model.account.AccountModel;
import com.niladri.accounts.model.customer.CustomerModel;
import com.niladri.accounts.repository.account.AccountRepo;
import com.niladri.accounts.repository.customer.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountService implements AccountServiceInterface {

    private AccountRepo accountRepo;
    private CustomerRepo customerRepo;


    @Override
    public AccountDto createAccount(CustomerModel customerDetails) {

        Optional<CustomerModel> customer = customerRepo.findByCustomerEmail(customerDetails.getCustomerEmail());
        if (customer.isPresent()) {
            throw new CustomerAlreadyExist("Customer already exist with email: " + customerDetails.getCustomerEmail());
        }

        CustomerModel newCustomer = customerRepo.save(customerDetails);
        AccountModel newAccount = accountRepo.save(createNewAccount(newCustomer));
        AccountDto newAccountDto = AccountMapper.mapToAccountDto(newAccount);
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(newCustomer);
        newAccountDto.setCustomerDetails(customerDto);
        return newAccountDto;

    }


    @Override
    public AccountDto getAccountDetails(Long accountNumber) {
        AccountModel accountModel = accountRepo.findById(accountNumber).orElseThrow(() -> new ResourceNotFound("Account", "Account number", accountNumber.toString()));
        CustomerModel customerModel = customerRepo.findById(accountModel.getCustomerId()).orElseThrow(() -> new ResourceNotFound("Customer", "Customer id", accountModel.getCustomerId().toString()));
        AccountDto accountDto = AccountMapper.mapToAccountDto(accountModel);
        accountDto.setCustomerDetails(CustomerMapper.mapToCustomerDto(customerModel));
        return accountDto;
    }

    @Override
    public AccountDto updateAccountDetails(Long accountNumber, AccountDto accountDetails) {
        AccountModel accountModel = accountRepo.findById(accountNumber).orElseThrow(() -> new ResourceNotFound("Account", "Account number", accountNumber.toString()));
        CustomerModel customer = CustomerMapper.mapToCustomerModel(accountDetails.getCustomerDetails());
        customerRepo.findById(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFound("Customer", "Customer id", customer.getCustomerId().toString()));
        CustomerModel updatedCustomer = customerRepo.save(customer);
        accountModel.setAccountType(accountDetails.getAccountType());
        accountModel.setBranchAddress(accountDetails.getBranchAddress());
       accountModel.setCustomerId(updatedCustomer.getCustomerId());
        AccountModel updatedAccount = accountRepo.save(accountModel);
        AccountDto updatedAccountDto = AccountMapper.mapToAccountDto(updatedAccount);
        updatedAccountDto.setCustomerDetails(CustomerMapper.mapToCustomerDto(updatedCustomer));
        return updatedAccountDto;
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        AccountModel accountModel = accountRepo.findById(accountNumber).orElseThrow(() -> new ResourceNotFound("Account", "Account number", accountNumber.toString()));
        accountRepo.delete(accountModel);
    }


    private AccountModel createNewAccount(CustomerModel customer) {
        AccountModel accountModel = new AccountModel();
        accountModel.setCustomerId(customer.getCustomerId());
        accountModel.setAccountType(AccountConstants.SAVINGS);
        accountModel.setBranchAddress(AccountConstants.ADDRESS);
        accountModel.setAccountNumber(1000000000L + new Random().nextInt(900000000));
        return accountModel;
    }
}

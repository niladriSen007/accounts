package com.niladri.accounts.mapper;

import com.niladri.accounts.dto.account.AccountDto;
import com.niladri.accounts.model.account.AccountModel;

public class AccountMapper {
    public static AccountModel mapToAccountModel(AccountDto accountDto) {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountNumber(accountDto.getAccountNumber());
        accountModel.setAccountType(accountDto.getAccountType());
        accountModel.setBranchAddress(accountDto.getBranchAddress());
        accountModel.setCustomerId(accountDto.getCustomerId());
        return accountModel;
    }

    public static AccountDto mapToAccountDto(AccountModel accountModel) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(accountModel.getAccountNumber());
        accountDto.setAccountType(accountModel.getAccountType());
        accountDto.setBranchAddress(accountModel.getBranchAddress());
        accountDto.setCustomerId(accountModel.getCustomerId());
        return accountDto;
    }
}

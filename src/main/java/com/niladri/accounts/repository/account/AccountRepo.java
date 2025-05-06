package com.niladri.accounts.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niladri.accounts.model.account.AccountModel;

public interface AccountRepo extends JpaRepository<AccountModel, Long> {

} 

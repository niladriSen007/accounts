package com.niladri.accounts.repository.account;

import com.niladri.accounts.model.account.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<AccountModel, Long> {

}

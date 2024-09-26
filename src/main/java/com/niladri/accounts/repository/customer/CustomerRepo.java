package com.niladri.accounts.repository.customer;

import com.niladri.accounts.model.customer.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Long> {
    Optional<CustomerModel> findByCustomerEmail(String email);
}

package com.niladri.accounts.model.account;

import com.niladri.accounts.model.common.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "account")
public class AccountModel  extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "account_number")
    private Long accountNumber;

//    @Column(name = "account_type")
    private String accountType;

//    @Column(name = "customer_id")
    private Long customerId;

//    @Column(name="branch_address")
    private String branchAddress;

}

package com.niladri.accounts.model.customer;

import com.niladri.accounts.model.common.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "customer")
public class CustomerModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id")
    private Long customerId;

//    @Column(name = "name")
    private String customerName;

//    @Column(name = "email")
    @NotBlank
    @Email
    private String customerEmail;

//    @Column(name = "mobile_number")
    private String customerPhone;
}

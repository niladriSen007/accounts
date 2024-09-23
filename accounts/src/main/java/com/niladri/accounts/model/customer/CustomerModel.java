package com.niladri.accounts.model.customer;

import com.niladri.accounts.model.common.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Customer name is mandatory")
    @Size(min = 3, max = 50,message = "Customer name must be between 3 and 50 characters")
    private String customerName;

//    @Column(name = "email")
    @NotBlank(message = "Customer email is mandatory")
    @Email
    private String customerEmail;

//    @Column(name = "mobile_number")
    @NotNull(message = "Customer phone is mandatory")
    @Size(min = 10, max = 10, message = "Customer phone must be 10 characters")
    private String customerPhone;
}

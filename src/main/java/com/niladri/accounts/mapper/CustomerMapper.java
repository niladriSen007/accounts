package com.niladri.accounts.mapper;

import com.niladri.accounts.dto.customer.CustomerDto;
import com.niladri.accounts.model.customer.CustomerModel;

public class CustomerMapper {
    public static CustomerModel mapToCustomerModel(CustomerDto customerDto) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId(customerDto.getCustomerId());
        customerModel.setCustomerEmail(customerDto.getCustomerEmail());
        customerModel.setCustomerName(customerDto.getCustomerName());
        customerModel.setCustomerPhone(customerDto.getCustomerPhone());
        return customerModel;
    }

    public static CustomerDto mapToCustomerDto(CustomerModel customerModel) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customerModel.getCustomerId());
        customerDto.setCustomerEmail(customerModel.getCustomerEmail());
        customerDto.setCustomerName(customerModel.getCustomerName());
        customerDto.setCustomerPhone(customerModel.getCustomerPhone());
        return customerDto;
    }
}

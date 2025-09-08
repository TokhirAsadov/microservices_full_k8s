package com.javatuz.accounts.service;

import com.javatuz.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     * */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}

package com.javatuz.accounts.service;

import com.javatuz.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * @param customerDto - CustomerDto object
     * */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    Boolean updateAccount(CustomerDto customerDto);
    Boolean deleteAccount(String mobileNumber);
}

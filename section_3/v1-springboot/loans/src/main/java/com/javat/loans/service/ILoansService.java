package com.javat.loans.service;

import com.javat.loans.dto.LoansDto;

public interface ILoansService {
    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    Boolean updateLoan(LoansDto loansDto);

    Boolean deleteLoan(String mobileNumber);
}

package com.javat.loans.service.impl;

import com.javat.loans.constants.LoansConstants;
import com.javat.loans.dto.LoansDto;
import com.javat.loans.entity.Loans;
import com.javat.loans.repository.LoansRepository;
import com.javat.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if (optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given mobile number: "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans  newLoans = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoans.setLoanNumber(Long.toString(randomLoanNumber));
        newLoans.setMobileNumber(mobileNumber);
        newLoans.setLoanType(LoansConstants.HOME_LOAN);
        newLoans.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoans.setAmountPaid(0);
        newLoans.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoans;
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {


        return null;
    }

    @Override
    public Boolean updateLoan(LoansDto loansDto) {
        return null;
    }

    @Override
    public Boolean deleteLoan(String mobileNumber) {
        return null;
    }
}

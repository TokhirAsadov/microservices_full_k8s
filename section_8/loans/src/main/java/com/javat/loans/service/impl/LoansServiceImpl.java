package com.javat.loans.service.impl;

import com.javat.loans.constants.LoansConstants;
import com.javat.loans.dto.LoansDto;
import com.javat.loans.entity.Loans;
import com.javat.loans.exception.LoanAlreadyExistsException;
import com.javat.loans.exception.ResourceNotFoundException;
import com.javat.loans.mapper.LoansMapper;
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
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoansMapper.mapToLoansDto(loans,new LoansDto());
    }

    @Override
    public Boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber())
        );
        LoansMapper.mapToLoans(loansDto,loans);
        loansRepository.save(loans);
        return true;
    }

    @Override
    public Boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->  new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return null;
    }
}

package com.javatuz.accounts.service.impl;

import com.javatuz.accounts.dto.AccountsDto;
import com.javatuz.accounts.dto.CardsDto;
import com.javatuz.accounts.dto.CustomerDetailsDto;
import com.javatuz.accounts.dto.LoansDto;
import com.javatuz.accounts.entity.Accounts;
import com.javatuz.accounts.entity.Customer;
import com.javatuz.accounts.exception.ResourceNotFoundException;
import com.javatuz.accounts.mapper.AccountsMapper;
import com.javatuz.accounts.mapper.CustomerMapper;
import com.javatuz.accounts.repository.AccountsRepository;
import com.javatuz.accounts.repository.CustomerRepository;
import com.javatuz.accounts.service.ICustomerService;
import com.javatuz.accounts.service.client.CardsFeignClient;
import com.javatuz.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoansDetails(correlationId,mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}

package com.bankapp.service.impl;

import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.entity.Account;
import com.bankapp.entity.Product;
import com.bankapp.exception.NotFoundException;
import com.bankapp.mapper.AccountMapper;
import com.bankapp.repository.AccountRepository;
import com.bankapp.service.AccountService;
import com.bankapp.service.util.DefaultConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.bankapp.service.util.DefaultConstants.BALANCE;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public AccountResponse create(AccountRequest accountRequest) {
        return null;
    }

    @Override
    public Account create(UUID clientId, Product product) {
        return Account.builder()
                .accountNumber( String.valueOf(accountRepository.count() + 1))
                .clientId(clientId)
                .currencyCode(product.getCurrencyCode())
                .currentBalance(BALANCE)
                .openDate(LocalDate.now())
                .closeDate(LocalDate.now().plusYears(DefaultConstants.PERIOD))
                .active(false)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Account getById(UUID id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Account.class, id)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Account getByNumber(String number) {
        return accountRepository.findByAccountNumber(number).orElseThrow(
                () -> new NotFoundException(Account.class, number)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountResponse> getAllClientAccounts(String clientId) {
        List<Account> accounts = accountRepository.findAllByClientId(UUID.fromString(clientId));

        if(accounts.isEmpty()) {
            throw new NotFoundException(Account.class);
        }
        return accounts.stream()
                .map(accountMapper::mapTo)
                .toList();
    }

    @Override
    @Transactional
    public List<Account> getAllActiveClientAccounts(UUID clientId) {
        List<Account> accounts = accountRepository.findAllActiveAccounts(clientId);

        if(accounts.isEmpty()) {
            throw new NotFoundException(Account.class);
        }
        return accounts;
    }

    @Override
    @Transactional
    public void terminateAccount(UUID id) {
        Account account = getById(id);
        account.setActive(false);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        accountRepository.deleteById(id);
    }
}

package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository)
    {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions()
    {
        List<AccountTransactionDto> accountTransactionDto = new ArrayList<>();
        try{
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll()){
                accountTransactionDto.add(new AccountTransactionDto(accountTransaction));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTransactionDto;

    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto)
    {
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTransactionDto.getTransactionType());
            return new AccountTransactionDto(accountTransaction);
        } catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }

    }




    @Override
    public AccountTransactionDto getAccountTransactionDtoByMnemonic(Long memberID)
    {
        try{
            return accountTransactionRepository.getAccountTransactionDtoByMnemonic(memberID);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }

    @Override
    public AccountTransactionDto save(AccountTransaction accountTransaction) {
        try {
            return new AccountTransactionDto(accountTransactionRepository.save(accountTransaction));
        } catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTransactionDto getAccountTransactionByMnemonic(String mnemonic) {
        return null;
    }




}
package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.util.List;
public interface AccountTransactionTranslator {

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto create(AccountTransactionDto accountType);

    AccountTransactionDto getAccountTransactionDtoByMnemonic(Long memberID);

    AccountTransactionDto save(AccountTransaction accountTransaction);

    AccountTransactionDto getAccountTransactionByMnemonic(String mnemonic);
}


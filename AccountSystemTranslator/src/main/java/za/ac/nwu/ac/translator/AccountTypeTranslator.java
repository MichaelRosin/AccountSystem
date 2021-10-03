package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    AccountTypeDto save(AccountType accountType);

    List<AccountTypeDto> getAllAccountTypes();


}


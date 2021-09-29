package za.ac.nwu.ac.logic;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);
}

package za.ac.nwu.ac.logic;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {

    List<AccountTypeDto> getAllAccountTypes();
}

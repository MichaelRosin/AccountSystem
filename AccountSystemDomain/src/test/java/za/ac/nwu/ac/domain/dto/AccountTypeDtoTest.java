package za.ac.nwu.ac.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTypeDtoTest {

    @Test
   public void getMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getMnemonic());
    }

    @Test
    public void getAccountTypeName() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getAccountTypeName());
    }

    @Test
    public void getCreationDate() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getCreationDate());
    }


}



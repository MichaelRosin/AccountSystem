package za.ac.nwu.ac.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTransactionDtoTest {

    @Test
    public void getMemberId() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getMemberId());
    }

    @Test
    public void getAmount() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getAmount());
    }

    @Test
    public void getTransactionDate() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getTransactionDate());
    }


}
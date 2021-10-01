package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void create() {
        when(translator.getAccountTypeDtoByMnemonic(anyString())).thenThrow(new RuntimeException());
        try {
            AccountTypeDto accountTypeDto = translator.getAccountTypeDtoByMnemonic("");
            flow.create(new AccountTypeDto());
            fail("Should throw an exception");
        } catch (Exception e) {


        }
        verify(translator, times(1)).getAccountTypeDtoByMnemonic(anyString());
        verify(translator, never()).create(any(AccountTypeDto.class));

    }
}
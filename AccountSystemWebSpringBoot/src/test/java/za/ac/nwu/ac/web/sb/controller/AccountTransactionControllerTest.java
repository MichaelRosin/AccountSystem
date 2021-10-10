
/*
package za.ac.nwu.ac.web.sb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {
    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TRANSACTION_CONTROLLER_URL = APP_URL +
            "/account-transaction";
    @Mock
    private FetchAccountTransactionFlow fetchAccountTransactionFlow;
    @Mock
    private CreateAccountTransactionFlow createAccountTransactionFlowTypeFlow;



    @InjectMocks
    private AccountTransactionController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"memberId\":\"MILES\",\"accountTransactionName\":\"Miles account transaction\",\"transactionDate\":[2020,1,1]}," +
                "{\"memberId\":\"PLAY\",\"accountTransactionName\":\"Play account transaction\",\"transactionDate\":[2021,4,1]}]}";
        List<AccountTransactionDto> accountTransaction = new ArrayList<>();
        accountTransaction.add(new AccountTransactionDto(12342L, 12L,
                LocalDate.parse("2020-01-01")));
        accountTransaction.add(new AccountTransactionDto(2L, 12L,
                LocalDate.parse("2021-04-01")));

        when(fetchAccountTransactionFlow.getAllTransactionTypes()).thenReturn(accountTransaction);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_TRANSACTION_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(fetchAccountTransactionFlow, times(1)).getAllTransactionTypes();
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void create() throws Exception {
        String accountTransactionToBeCreated =
                "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles account type\",\"creationDate\":[2020,1,1]},";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles account type\",\"creationDate\":[2020,1,1]}}";
        AccountTransactionDto accountTransaction = new AccountTransactionDto(12L, 244L, LocalDate.parse("2020-01-01"));

        when(createAccountTransactionFlowTypeFlow.create(eq(accountTransaction))).then(returnsFirstArg());
        MvcResult mvcResult =
                mockMvc.perform(post(ACCOUNT_TRANSACTION_CONTROLLER_URL)
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(accountTransactionToBeCreated)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andReturn();
        verify(createAccountTransactionFlowTypeFlow, times(1)).create(eq(accountTransaction));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
}


*/


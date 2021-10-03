package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")

public class AccountTransactionDto implements Serializable{

    private static final long serialVersionUID = -5346853206480289868L;

    private Long memberID;
    private Long amount;
    private LocalDate transactionDate;


    public AccountTransactionDto()
    {

    }

    public AccountTransactionDto(Long memberID, Long amount, LocalDate transactionDate)
    {
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction)
    {
        this.setMemberID(accountTransaction.getMemberId());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction memberID",
            name = "MemberID",
            notes = "Uniquely identifies the member",
            dataType = "java.lang.String",
            example = "123",
            required = true)
    public Long getMemberID()
    {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction Amount",
            name = "amount",
            notes = "The amount of miles transferred",
            dataType = "java.lang.String",
            example = "12",
            allowEmptyValue = false,
            required = true)
    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction TransactionDate",
            name = "TransactionDate",
            notes = "This is the date on which the AccountTransaction occurred",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)
    public LocalDate getTransactionDate()
    {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }


   @JsonIgnore
    public AccountTransaction getTransactionType()
    {
        return new AccountTransaction(getMemberID(), getAmount(),getTransactionDate());
    }


    @Override
    public int hashCode() {
        return Objects.hash(memberID, amount, transactionDate);
    }



}

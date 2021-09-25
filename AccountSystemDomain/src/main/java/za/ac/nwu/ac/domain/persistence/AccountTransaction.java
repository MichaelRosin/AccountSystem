package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "HR")


public class AccountTransaction implements Serializable {

    private Long transactionId;
    private AccountType accountTypeId;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;


    public AccountTransaction()
    {
    }

    public AccountTransaction(Long transactionId, AccountType accountTypeId, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "HR.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "TransactionID")
    private Long getTransactionId()
    {
        return transactionId;
    }


    @Column(name = "MemberID")
    private Long getMemberId()
    {
        return memberId;
    }


    @Column(name = "Amount")
    private Long getAmount()
    {
        return amount;
    }


    @Column(name = "TransactionDate")
    private LocalDate getTransactionDate()
    {
        return transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Type_ID")

    public AccountType getAccountTypeId()
    {
        return accountTypeId;
    }

    public void setTransactionId(Long transactionId)
    {
        this.transactionId = transactionId;
    }

    public void setAccountTypeId(AccountType accountType)
    {
        this.accountTypeId = accountType;
    }

    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeId, memberId, amount, transactionDate);
    }
}

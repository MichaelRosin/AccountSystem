package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "hr")


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

    public AccountTransaction(Long memberId, Long amount, LocalDate transactionDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_TRANSACTION_SEQ", sequenceName = "HR.ACCOUNT_TRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TRANSACTION_SEQ")
    @Column(name = "TransactionID")
    public Long getTransactionId()
    {
        return transactionId;
    }


    @Column(name = "MemberId")
    public Long getMemberId()
    {
        return memberId;
    }


    @Column(name = "Amount")
    public Long getAmount()
    {
        return amount;
    }


    @Column(name = "TransactionDate")
    public LocalDate getTransactionDate()
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
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeId, that.accountTypeId) &&
                Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) &&
                Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeId, memberId, amount, transactionDate);
    }
}

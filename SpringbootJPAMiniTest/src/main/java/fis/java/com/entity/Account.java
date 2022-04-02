package fis.java.com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

@AllArgsConstructor

@Entity
@Table(name = "Account", catalog = "testminitest")

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "accountNumber", nullable = false, unique = false)
	private String accountNumber;

	@Column(name = "accountName", nullable = false, length = 15)
	private String accountName;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "status")
	private int status;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountNumber", referencedColumnName = "id")
	List<Transaction> ListTransaction;

	public Account() {
		super();
	}

	public Account(String accountNumber, String accountName, Double blance, int status) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = blance;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBlance() {
		return balance;
	}

	public void setBlance(Double blance) {
		this.balance = blance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Transaction> getListTransaction() {
		return ListTransaction;
	}

	public void setListTransaction(List<Transaction> listTransaction) {
		ListTransaction = listTransaction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Account account = (Account) o;
		return Objects.equals(id, account.id) && Objects.equals(accountNumber, account.accountNumber)
				&& Objects.equals(accountName, account.accountName) && Objects.equals(balance, account.balance)
				&& Objects.equals(status, account.status);
	}

}

package fis.java.com.dto;

import javax.validation.constraints.NotBlank;

import fis.java.com.entity.Account;


public class AccountDTO {
	
	@NotBlank
	private String accountNumber;
	@NotBlank
	private String accountName;
	
	private Double blance;
	
	private int status;
	
	public Account toEntity() {
		return new Account(accountNumber,accountName,blance,status);
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
		return blance;
	}

	public void setBlance(Double blance) {
		this.blance = blance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

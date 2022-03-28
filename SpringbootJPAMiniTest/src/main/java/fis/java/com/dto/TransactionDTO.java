package fis.java.com.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class TransactionDTO {
	@NotBlank
	private Date transactionDate;
	@NotBlank
	private Long fromAccount;
	@NotBlank
	private Long toAccount;
	@NotBlank
	// Số tiền thực hiện chuyển khoản
	private Double amount;
	private int status;
// Nội dung thực hiện giao dịch
	private String content;
// Lý do giao dịch lỗi ví dụ: Số dư tài khoản không đủ, tài khoản nhận
//	tiền không tồn tại hoặc tạm 	khoá.	
	private String errorReason;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

}

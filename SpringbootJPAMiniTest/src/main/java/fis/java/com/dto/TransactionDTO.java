package fis.java.com.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import fis.java.com.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter

public class TransactionDTO {
	@NotBlank(message = "")
	private Date transactionDate;
	@NotBlank
	@NotNull(message = "không được bỏ trống tài khoản nguồn!")
	private Account fromAccount;
	@NotBlank
	@NotNull(message = "không bỏ trống tài khoản thừa hưởng!")
	private Account toAccount;
	@NotBlank
	// Số tiền thực hiện chuyển khoản
	private Double amount;
	private int status;
// Nội dung thực hiện giao dịch
	@Length(max =50,min = 15, message = "nội dung giao dịch không vượt quá 50 ký tự!")
	private String content;
// Lý do giao dịch lỗi ví dụ: Số dư tài khoản không đủ, tài khoản nhận
//	tiền không tồn tại hoặc tạm 	khoá.	
	private String errorReason;

}

package fis.java.com.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.com.Repository.IAccountRepo;
import fis.java.com.Repository.TransactionRepo;
import fis.java.com.dto.TransactionDTO;
import fis.java.com.entity.Account;
import fis.java.com.entity.Transaction;

@Service
@Transactional
public class TransactionSevice implements ITransactionSevice {

	@Autowired
	private TransactionRepo transactionRepo;
	@Autowired
	IAccountRepo accRepository;

	@Override
	public void deleteTransactionById(Long id) {

		transactionRepo.deleteById(id);
	}

	@Override
	public  Transaction bankMoney(TransactionDTO formtransaction) {
		List<Account> listaccount = new ArrayList<>();
		Account fromaccount = new Account();
		Account toaccount = new Account();
		listaccount.add(toaccount);
		listaccount.add(fromaccount);		
		String errorReason = "";
		int status=1;
	
		for (Account account : listaccount) {
			if (accRepository.existsByAccountNumber(account.getAccountNumber()) == false || account.getStatus() != 1
					|| account.getBlance() <= formtransaction.getAmount()) {

				errorReason = "Lỗi giao dịch! tài khoản sai hoặc số dư k đủ ! vui lòng kiểm tra lại!";

			}else {
			Date date= new Date();
			Transaction transaction= new Transaction(date, fromaccount, toaccount, formtransaction.getAmount(), status,formtransaction.getContent(), errorReason);								
			if(status==1) {
				fromaccount.setBlance(fromaccount.getBlance()-formtransaction.getAmount());
				toaccount.setBlance(toaccount.getBlance()+formtransaction.getAmount());
				accRepository.save(fromaccount);
				accRepository.save(toaccount);
				transactionRepo.save(transaction);			
		}else {
			transactionRepo.save(transaction);
		}		
			return transaction;
	}
			
	}
		
	}

}

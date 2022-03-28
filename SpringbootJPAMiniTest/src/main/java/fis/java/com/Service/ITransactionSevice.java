package fis.java.com.Service;

import fis.java.com.dto.TransactionDTO;
import fis.java.com.entity.Transaction;

public interface ITransactionSevice {

	void deleteTransactionById(Long id);

	Transaction bankMoney(TransactionDTO formtransaction);

}

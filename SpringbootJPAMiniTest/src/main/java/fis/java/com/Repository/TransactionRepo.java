package fis.java.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fis.java.com.dto.TransactionDTO;
import fis.java.com.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	void save(TransactionDTO transaction);
	
	
}

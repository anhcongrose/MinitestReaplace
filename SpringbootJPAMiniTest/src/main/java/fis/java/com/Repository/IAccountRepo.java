package fis.java.com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import fis.java.com.dto.TransactionDTO;
import fis.java.com.entity.Account;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
//	Optional<Account> findByAccountNumber(String accountNumber);
	List<Account> findByAccountNumber(String accountNumber);
	boolean existsByAccountNumber(String accountNumber);
	void save(TransactionDTO transaction);

}

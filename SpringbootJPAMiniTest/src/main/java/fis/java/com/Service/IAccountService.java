package fis.java.com.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import fis.java.com.dto.ResponseDTO;
import fis.java.com.entity.Account;

@Component
public interface IAccountService {

	boolean existsAccountByAccountNumber(String accountNumber);

	List<Account> getAllAccounts();

	ResponseDTO createAccount(Account account);

	Account update(Account account);

	void deleteById(Long id);

	Account getAccountByID(Long id);

//	void createAccount(AccountDTO form) throws Exception;

}

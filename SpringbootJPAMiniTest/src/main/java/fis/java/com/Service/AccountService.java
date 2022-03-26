package fis.java.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fis.java.com.Repository.IAccountRepo;
import fis.java.com.entity.Account;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepo Iripository;

	@Override
	public Account update(Account account) {		
		return Iripository.save(account);
	}

	@Override
	public void deleteById(Long id) {

		Iripository.deleteById(id);
	}

	@Override
	public Account getAccountByID(Long id) {

		return Iripository.findById(id).get();
	}

	@Override
	public void createAccount(Account account) {

		Iripository.save(account);
	}

}

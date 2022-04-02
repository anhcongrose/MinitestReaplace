package fis.java.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.com.Repository.IAccountRepo;
import fis.java.com.dto.ResponseDTO;
import fis.java.com.entity.Account;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepo accRepository;

	@Override
	public boolean existsAccountByAccountNumber(String accountNumber) {

		return accRepository.existsByAccountNumber(accountNumber);
	}

	@Override
	public List<Account> getAllAccounts() {

		return accRepository.findAll();
	}

	@Override
	public Account update(Account account) {
		return accRepository.save(account);
	}

	@Override
	public void deleteById(Long id) {

		accRepository.deleteById(id);
	}

	@Override
	public Account getAccountByID(Long id) {

		return accRepository.findById(id).get();
	}

//
//	@Override
//	public void createAccount(Account account) {
//
//		accRepository.save(account);
//
//	}
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ResponseDTO createAccount(Account account) {
		ResponseDTO respo = new ResponseDTO();
		String masage = "số tài khoản đã tồn tại";
		Account account1 = new Account();
		if (account.getAccountNumber().equals(accRepository.existsByAccountNumber(account1.getAccountName()))) {
			respo.setCode("erro");
			respo.setMassage(masage);
			return respo;
		}
		Account accoun1 = accRepository.save(account);
		respo.setCode("sucssec");
		respo.setMassage("thanh cong");
		respo.setData(accoun1);

		return respo;
	}

}

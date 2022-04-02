package fis.java.com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.com.Service.ITransactionSevice;
import fis.java.com.dto.TransactionDTO;

@Validated
@RestController
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {

	@Autowired
	private ITransactionSevice transacService;

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<?> deleteTransaction(@PathVariable(name = "id") Long id) {
		transacService.deleteTransactionById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody @Valid TransactionDTO formtransaction) {

		return ResponseEntity.ok(transacService.CreatebankMoney(formtransaction));
	}
}

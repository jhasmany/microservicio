package aforo255.ms.test.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aforo255.ms.test.transaction.entity.Transaction;
import aforo255.ms.test.transaction.service.ITransactionService;


@RestController
public class TransactionController {

	@Autowired
	ITransactionService _transaction ;	
	
	@GetMapping("listar")	
	public List<Transaction> listar (){
		
		return (List<Transaction>)_transaction.findAll();
	}
	
	@GetMapping ("/transaction/{invoiceId}")
	public ResponseEntity<?> findByInvoiceId (@PathVariable Integer invoiceId){
		Iterable<Transaction> transaction= _transaction.findByInvoiceId(invoiceId);
		return ResponseEntity.ok(transaction);
	}	
}
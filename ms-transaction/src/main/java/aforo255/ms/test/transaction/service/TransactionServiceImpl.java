package aforo255.ms.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aforo255.ms.test.transaction.entity.Transaction;
import aforo255.ms.test.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	TransactionRepository _repository;
	
	@Override
	public Transaction save(Transaction Transaction) {
		return _repository.save(Transaction);
	}

	@Override
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId) {
		return _repository.findByInvoiceId(invoiceId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		return _repository.findAll();
	}

}
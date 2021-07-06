package aforo255.ms.test.transaction.service;

import aforo255.ms.test.transaction.entity.Transaction;

public interface ITransactionService {
	public Transaction save (Transaction transaction);
	public Iterable<Transaction> findByInvoiceId (Integer invoiceId);
	public Iterable <Transaction> findAll();
}

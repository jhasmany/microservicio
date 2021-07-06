package aforo255.ms.test.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import aforo255.ms.test.transaction.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
	@Query("{'invoiceId':?0}")
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId);
}

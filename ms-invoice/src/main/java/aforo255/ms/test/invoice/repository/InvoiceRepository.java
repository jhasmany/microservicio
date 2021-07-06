package aforo255.ms.test.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import aforo255.ms.test.invoice.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {

}

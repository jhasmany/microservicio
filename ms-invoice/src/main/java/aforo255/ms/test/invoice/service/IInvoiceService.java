package aforo255.ms.test.invoice.service;

import java.util.List;

import aforo255.ms.test.invoice.entity.Invoice;

public interface IInvoiceService {

	public List<Invoice> findAll();
	public Invoice findById (Integer id ); 
	public Invoice save (Invoice invoice);
	
}

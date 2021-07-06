package aforo255.ms.test.invoice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aforo255.ms.test.invoice.entity.Invoice;
import aforo255.ms.test.invoice.repository.InvoiceRepository;
@Service
public class InvoiceServiceImpl implements IInvoiceService{

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return  (List<Invoice>)invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(Integer id) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Invoice save(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}

}

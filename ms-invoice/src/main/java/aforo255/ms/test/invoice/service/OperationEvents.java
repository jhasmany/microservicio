package aforo255.ms.test.invoice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aforo255.ms.test.invoice.entity.Invoice;
import aforo255.ms.test.invoice.entity.Operation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class OperationEvents {
	@Autowired
	private IInvoiceService invoiceService;
	private Logger log = LoggerFactory.getLogger(OperationEvents.class);
	
	@Autowired
	private ObjectMapper objectMapper ;	
	public void processOperationEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		Invoice invoice = new Invoice();
		Operation event = objectMapper.readValue(consumerRecord.value(), Operation.class);
		
		invoice = invoiceService.findById(event.getInvoiceId());
		invoice.setAmount(event.getAmount());
		invoice.setState(1);
		
		log.info("Update state ***"+event.getId());
		invoiceService.save(invoice);
	}

}

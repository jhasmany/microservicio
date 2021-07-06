package aforo255.ms.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aforo255.ms.test.transaction.entity.Operation;
import aforo255.ms.test.transaction.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class TransactionEvents {

	@Autowired
	private ITransactionService service;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		Operation event = objectMapper.readValue(consumerRecord.value(), Operation.class);
		log.info("OperationEvent : {}", event.getId());
		Transaction transaction = new Transaction();
		transaction.setTransactionId(sequenceGeneratorService.getSequenceNumber(transaction.SEQUENCE_NAME));
		transaction.setInvoiceId(event.getInvoiceId());
		transaction.setAmount(event.getAmount());
		transaction.setDateTransaction(LocalDate.now());
		service.save(transaction);
	}
	
}


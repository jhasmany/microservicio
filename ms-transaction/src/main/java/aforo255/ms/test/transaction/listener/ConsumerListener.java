package aforo255.ms.test.transaction.listener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import aforo255.ms.test.transaction.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Component
public class ConsumerListener {
	@Autowired
	private TransactionEvents _transactionEvents;
	private Logger log = LoggerFactory.getLogger(ConsumerListener.class);
	
	@KafkaListener(topics = {"operation-events"})
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info("*************** MICROSERVICE TRANSACTION *******************");
		log.info("ConsumerRecord : {}", consumerRecord.value());
		
		_transactionEvents.processTransactionEvent(consumerRecord);
	}
	
}

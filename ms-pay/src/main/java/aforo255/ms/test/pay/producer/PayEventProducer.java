package aforo255.ms.test.pay.producer;

import java.util.List;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import aforo255.ms.test.pay.domain.Operation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PayEventProducer {

	String topic="operation-events";
	private Logger log = LoggerFactory.getLogger(PayEventProducer.class);
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	@Autowired
	ObjectMapper objectMapper;
	//@Autowired
	//private ITransactionService _service;
	
	public ListenableFuture<SendResult<Integer, String>> sendPayEvent(Operation payEvent)
			throws JsonProcessingException {
		Integer key = payEvent.getId();
		String value = objectMapper.writeValueAsString(payEvent);

		ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, topic);
		ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				
				try {
					handleSuccess(key, value, result);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key, value, ex);

			}
		});

		return listenableFuture;
	}

	
	
	private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
		List<Header> recordHeaders = List.of(new RecordHeader("pay-event-source", "scanner".getBytes()));
		return new ProducerRecord<>(topic, null, key, value, recordHeaders);
	}
	
	
	private void handleFailure(Integer key, String value, Throwable ex) {
		log.error("Error enviando el mensage y el error es {}", ex.getMessage());
		try {

		} catch (Throwable throwable) {
			log.error("Error en OnFailure {}", throwable.getMessage());
		}
	}
	
	
	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) throws JsonMappingException, JsonProcessingException {
		//TransactionRedis trxRedis = objectMapper.readValue(value, TransactionRedis.class);
		//_service.save(trxRedis);
		log.info("Message Sent Successfully for the key :{} and the value is {},partition is {}", key, value,
				result.getRecordMetadata().partition());
		
	}
	
	
	
}

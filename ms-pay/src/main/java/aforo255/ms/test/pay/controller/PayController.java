package aforo255.ms.test.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import java.util.Map;
import aforo255.ms.test.pay.domain.Operation;
import aforo255.ms.test.pay.producer.PayEventProducer;
import aforo255.ms.test.pay.service.IOperationService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class PayController {
	@Autowired
	private IOperationService service;
	@Autowired
	PayEventProducer eventProducer;
	private Logger log = LoggerFactory.getLogger(PayController.class);
	
	@PostMapping("/v1/pay-event")
	public ResponseEntity<Operation> postPayEvent(@RequestBody Operation ope) throws JsonProcessingException {
		log.info("before operation");
		Operation operation = service.save(ope);
		log.info("after operation");
		
		log.info("before sendPayEvent");
		eventProducer.sendPayEvent(operation);
		log.info("after sendPayEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(ope);
	}	

	//@GetMapping("/all")
	//public Map<String , TransactionRedis> getAll(){		
	//	return service.findAll();
	//}	
	
}

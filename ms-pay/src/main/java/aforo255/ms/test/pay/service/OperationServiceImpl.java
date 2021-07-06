package aforo255.ms.test.pay.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aforo255.ms.test.pay.domain.Operation;
import aforo255.ms.test.pay.dao.IOperationDao;

@Service
public class OperationServiceImpl implements IOperationService {

	@Autowired
	private IOperationDao operationDao;
	
	@Override
	@Transactional
	public Operation save(Operation operation) {
		return operationDao.save(operation);
	}	

}

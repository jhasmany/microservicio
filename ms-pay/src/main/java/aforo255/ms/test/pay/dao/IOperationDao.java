package aforo255.ms.test.pay.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import aforo255.ms.test.pay.domain.Operation;

@Repository
public interface IOperationDao extends CrudRepository<Operation, Integer> {

}

package tacos.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Taco;
import tacos.model.TacoOrder;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip (String deliveryZip);

    
}

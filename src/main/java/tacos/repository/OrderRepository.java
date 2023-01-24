package tacos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Taco;
import tacos.model.TacoOrder;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip (String deliveryZip);

    List<TacoOrder> findByTacosId (Long id);
    
}

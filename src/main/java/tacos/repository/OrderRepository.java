package tacos.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.TacoOrder;
import java.util.UUID;



public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
    
}

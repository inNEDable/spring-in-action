package tacos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Taco;

import java.util.List;
import java.util.Optional;

@Repository
public interface TacoRepository extends JpaRepository<Taco,Long > {

}

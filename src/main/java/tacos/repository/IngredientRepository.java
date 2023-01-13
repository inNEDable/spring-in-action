package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.Ingredient;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

}

package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}

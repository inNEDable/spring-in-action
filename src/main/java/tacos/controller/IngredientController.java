package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.model.Ingredient;
import tacos.repository.IngredientRepository;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(path = "/api/ingredients", produces = "application/json")
public class IngredientController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping()
    public Iterable<Ingredient> allIngredients (){
        return ingredientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Ingredient saveIngredient (@RequestBody Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteIngredient (@PathVariable("id") String id){
        ingredientRepository.deleteById(id);
    }


}

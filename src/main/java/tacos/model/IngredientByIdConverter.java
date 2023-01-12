package tacos.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.model.Ingredient.*;
import tacos.repository.JdbcIngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private JdbcIngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(JdbcIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}

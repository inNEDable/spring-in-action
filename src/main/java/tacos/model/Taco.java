package tacos.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
@Data
public class Taco {

    @Id
    private Long id;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredients;

    private Date createdAt = new Date();

    public void addIngredient (Ingredient ingredient){
        this.ingredients.add(new IngredientRef(ingredient.getId()));
    }

}

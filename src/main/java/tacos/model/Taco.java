package tacos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @NotNull
//    @Size(min = 5, message = "Name must be at least 5 characters")
    private String name;

    private Date createdAt = new Date();

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();


    public void addIngredient (Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

}

package tacos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;


@Table
@Getter
@Setter
@AllArgsConstructor
public class Ingredient implements Persistable<String> {

    /**
     * THE WHOLE SHIT WITH IMPLEMENTING PERSISTABLE IS BECAUSE FOR SOME FUCKING REASON SPRING DATA JDBC
     * REFUSES TO SAVE AN INGREDIENT WHEN IT HAS AN ID SET. IT THINKS THAT SINCE IT HAS ID, WE ARE TRYING TO UPDATE THE ROW IN THE DB.........
     *
     */
    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    @Id
    private String id;
    private String name;
    private Type type;
}

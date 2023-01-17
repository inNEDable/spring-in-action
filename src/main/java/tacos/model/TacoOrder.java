package tacos.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class TacoOrder {

    private static final Long serialVersionUID = 1L;

    @Id
    private String id;


    @NotBlank(message = "Name is missing")
    private String deliveryName;

    @NotBlank(message = "Street is missing")
    private String deliveryStreet;

    @NotBlank(message = "City is missing")
    private String deliveryCity;

    @NotBlank(message = "State is missing")
    private String deliveryState;

    @NotBlank(message = "Zip code is missing")
    private String deliveryZip;

    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private Date placedAt = new Date();

    private List<Taco> tacos = new ArrayList<>();


    public void addTaco (Taco taco){
        tacos.add(taco);
    }

}

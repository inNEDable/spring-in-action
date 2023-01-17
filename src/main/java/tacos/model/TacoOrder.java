package tacos.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class TacoOrder {

    private static final Long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();
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

    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();


    public void addTaco (TacoUDT taco){
        tacos.add(taco);
    }

}

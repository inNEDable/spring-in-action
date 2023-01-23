package tacos.configuration;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Data
@ConfigurationProperties(prefix = "controllers.props")
@Validated
public class MyPropertiesHolder {

    @Min(value=5, message="must be between 5 and 25")
    @Max(value=25, message="must be between 5 and 25")
    private Integer tacoOrderPageSize = 20;

    private Integer maxIngredientsPerTaco = 5;

    private Integer usernameMinSize = 3;

}


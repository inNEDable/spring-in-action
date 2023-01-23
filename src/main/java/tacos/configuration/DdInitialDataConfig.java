package tacos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tacos.model.Ingredient;
import tacos.model.Ingredient.Type;
import tacos.model.User;
import tacos.repository.IngredientRepository;
import tacos.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Configuration
public class DdInitialDataConfig {

    @Bean
    public CommandLineRunner loadData (IngredientRepository ingredientRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User admin = new User(
                        "admin", passwordEncoder.encode("123"), "Bash ADmina",
                        "Tsarigradsko Shose 135", "Sofia", "Sofia", "1000", "0876112233");
                admin.setRole(RoleConstants.ADMIN_ROLE);
                User user = new User(
                        "user", passwordEncoder.encode("123"), "Obiknoven Potrebitel",
                        "Zapaden Park", "Sofia", "Sofia", "1000", "0876350570");
                user.setRole(RoleConstants.USER_ROLE);
                userRepository.saveAll(List.of(admin, user));


                ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
            }
        };
    }
}

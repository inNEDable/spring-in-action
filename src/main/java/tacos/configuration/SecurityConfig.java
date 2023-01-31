package tacos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tacos.model.User;
import tacos.repository.UserRepository;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username);
                if (user != null) return user;
                throw new UsernameNotFoundException("User " + username + " not found!");
            }
        };
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                // OAuth 2 configurations
                .antMatchers(HttpMethod.POST, "/api/ingredients")
                .hasAuthority("SCOPE_writeIngredients")
                .antMatchers(HttpMethod.DELETE, "/api//ingredients")
                .hasAuthority("SCOPE_deleteIngredients")


                .antMatchers("/design", "/orders", "design/**", "design/*", "/design*").authenticated()
                .antMatchers("/", "/**", "/h2-console/**", "/h2-console/*", "/console/**").permitAll()
                .requestMatchers(toH2Console()).permitAll()
                .and()

                // OAuth 2 Config
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                // END OF  OAuth 2 configurations

                .csrf().ignoringRequestMatchers(toH2Console())
                .and()

                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/design")
                .and()

                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                .and()

                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console());
    }


}

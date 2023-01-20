package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.configuration.RoleConstants;
import tacos.dto.RegistrationForm;
import tacos.model.User;
import tacos.repository.UserRepository;

import static tacos.configuration.RoleConstants.ADMIN_ROLE;
import static tacos.configuration.RoleConstants.USER_ROLE;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registrationForm (){
        return "registration";
    }

    @PostMapping
    public String processRegistration (RegistrationForm form){
        User user = form.toUser(passwordEncoder);
        user.setRole(form.getUsername().toLowerCase().contains("admin") ? ADMIN_ROLE : USER_ROLE);
        userRepository.save(user);
        return "redirect:/login";
    }


}

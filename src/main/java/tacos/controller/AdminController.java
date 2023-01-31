package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tacos.model.User;
import tacos.repository.OrderRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private OrderRepository orderRepository;

    @Autowired
    public AdminController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/deleteOrders")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAllOrders (@AuthenticationPrincipal User user){
        orderRepository.deleteAll();
        return "home";
    }
}

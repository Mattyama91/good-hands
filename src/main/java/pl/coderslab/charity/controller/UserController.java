package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.model.User;

@Controller
public class UserController  {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("register")
    public String createUser(User user) {
        userService.saveUser(user);
        return "login";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
}

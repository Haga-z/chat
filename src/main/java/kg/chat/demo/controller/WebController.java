package kg.chat.demo.controller;

import kg.chat.demo.Repositories.RoleRepository;
import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.Role;
import kg.chat.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class WebController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/")
    public String mainPage(Model model, Principal principal) {
        model.addAttribute("user", userRepository.findByUsername(principal.getName()).get());
        model.addAttribute("role",userRepository.findByUsername(principal.getName()).get().getRoles().get(0));
        return "index";
    }
    @GetMapping("/add_employee")
    public String addEmployee(Model model, Principal principal){
        model.addAttribute("user", userRepository.findByUsername(principal.getName()));
        model.addAttribute("role",userRepository.findByUsername(principal.getName()).get().getRoles().get(0));
        return "add_employee";
    }

    @PostMapping("/add_employee")
    public String addNewEmployee(
            @RequestParam("username")String username, @RequestParam("password")String password,
            Model model, Principal principal){
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        User user = User.builder()
                .created_at(OffsetDateTime.now())
                .password(encoder.encode(password))
                .roles(roles)
                .username(username)
                .build();
        userRepository.save(user);

        return "redirect:/index";
    }
}

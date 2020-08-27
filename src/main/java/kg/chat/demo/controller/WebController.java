package kg.chat.demo.controller;

import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.OffsetDateTime;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class WebController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/")
    public String mainPage(Model model, Principal principal) {
        model.addAttribute("user", userRepository.findByUsername(principal.getName()).get());
        return "index";
    }
    @GetMapping("/add_employee")
    public String addEmployee(Model model, Principal principal){
        model.addAttribute("user", userRepository.findByUsername(principal.getName()));
        return "add_employee";
    }

    @PostMapping("/add_employee")
    public String addNewEmployee(
            @RequestParam("username")String username, @RequestParam("password")String password,
            Model model, Principal principal){
        User user = User.builder()
                .created_at(OffsetDateTime.now())
                .password(encoder.encode(password))
                .username(username)
                .build();


        return "redirect:/employees";
    }
}

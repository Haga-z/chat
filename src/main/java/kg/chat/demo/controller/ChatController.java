package kg.chat.demo.controller;

import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.service.ChatUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping
@AllArgsConstructor
public class ChatController {
    private final ChatUserService chatUserService;
    private final UserRepository userRepository;

    @GetMapping("/chats")
    public String getChats(Principal principal, Model model){
        model.addAttribute("chats",chatUserService.getChatUser(principal));
        model.addAttribute("user",userRepository.findByUsername(principal.getName()));
        return "chats";

    }

}

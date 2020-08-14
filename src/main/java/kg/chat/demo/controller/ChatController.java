package kg.chat.demo.controller;

import kg.chat.demo.Repositories.ChatRepository;
import kg.chat.demo.Repositories.ChatUserRepository;
import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.Chat;
import kg.chat.demo.model.ChatUser;
import kg.chat.demo.model.User;
import kg.chat.demo.service.ChatUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class ChatController {
    private final ChatUserService chatUserService;

    @GetMapping("/chats")
    public String getChats(Principal principal, Model model){
        model.addAttribute("chats",chatUserService.getChatUser(principal));
        return "chats";

    }

}

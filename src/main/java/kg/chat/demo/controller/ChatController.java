package kg.chat.demo.controller;

import kg.chat.demo.DTO.ChatDTO;
import kg.chat.demo.DTO.MessageDTO;
import kg.chat.demo.DTO.UserDTO;
import kg.chat.demo.Repositories.ChatRepository;
import kg.chat.demo.Repositories.ChatUserRepository;
import kg.chat.demo.Repositories.MessageRepository;
import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.Chat;
import kg.chat.demo.model.ChatUser;
import kg.chat.demo.model.Message;
import kg.chat.demo.model.User;
import kg.chat.demo.service.ChatUserService;
import kg.chat.demo.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.time.OffsetDateTime;
import java.util.stream.Collectors;


@Controller
@RequestMapping
@AllArgsConstructor
public class ChatController {
    private final ChatUserService chatUserService;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;



    @GetMapping("/chats")
    public String getChats(Principal principal, Model model){
        model.addAttribute("chats",chatUserService.getChatUser(principal));
        model.addAttribute("user",UserDTO.from(userRepository.findByUsername(principal.getName()).get()));
        return "chats";

    }
    @GetMapping("/chat/{id}")
    public String getSingleChat(Principal principal,
                                @PathVariable("id") Integer id,
                                Model model){
        var user = userRepository.findByUsername(principal.getName());
        var messages = messageRepository.findAllByChatId(id).stream().map(MessageDTO::from).collect(Collectors.toList());
        model.addAttribute("messages",messages);
        model.addAttribute("chat", ChatDTO.from(chatRepository.findById(id).get()));
        model.addAttribute("user", UserDTO.from(user.get()));
        return "single_chat";
    }

    @RequestMapping(value = "/chat/{id}", method = RequestMethod.POST)
    public void createMessage(@PathVariable("id")Integer id,
                              @RequestParam("message")String message,
                              Principal principal){
        Message m = Message.builder()
                .chat(chatRepository.findById(id).get())
                .created_at(OffsetDateTime.now())
                .text(message)
                .delivered(false)
                .user(userRepository.findByUsername(principal.getName()).get())
                .build();
        messageRepository.save(m);
    }
    @GetMapping("/add_new_chat")
    public String addNewChat(Principal principal,Model model){
        var user = userRepository.findByUsername(principal.getName());
        var users = userRepository.findAllByUsernameIsNot(principal.getName());
        model.addAttribute("user", user.get());
        model.addAttribute("users",users);
        return "create_chat";
    }
    @PostMapping("/create_chat")
    public String createChat(@RequestParam("user_id")Integer id,
                             @RequestParam("chat_name")String name,Principal principal){
      return chatUserService.createChat(id, name, principal);
    }
}

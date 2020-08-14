package kg.chat.demo.service;

import kg.chat.demo.DTO.ChatUserDTO;
import kg.chat.demo.Repositories.ChatRepository;
import kg.chat.demo.Repositories.ChatUserRepository;
import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.ChatUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ChatUserService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ChatUserRepository chatUserRepository;

    public List<ChatUserDTO> getChatUser(Principal principal){
        var user = userRepository.findByUsername(principal.getName()).get();
        List <ChatUserDTO> chats = chatUserRepository.findAllByUserId(user.getId()).stream().map(ChatUserDTO::from).collect(Collectors.toList());
        return chats;
    }
}

package kg.chat.demo.service;

import kg.chat.demo.DTO.ChatUserDTO;
import kg.chat.demo.Repositories.ChatRepository;
import kg.chat.demo.Repositories.ChatUserRepository;
import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.Chat;
import kg.chat.demo.model.ChatUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ChatUserService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ChatUserRepository chatUserRepository;

    public List<ChatUserDTO> getChatUser(Principal principal) {
        var user = userRepository.findByUsername(principal.getName()).get();
        List<ChatUserDTO> chats = chatUserRepository.findAllByUserId(user.getId()).stream().map(ChatUserDTO::from).collect(Collectors.toList());
        return chats;
    }

    public String createChat(Integer id, String name, Principal principal) {
        var user = userRepository.findByUsername(principal.getName());
        var myChats = chatUserRepository.findAllByUserId(user.get().getId());
        var chats = chatUserRepository.findAllByUserId(id);
        for (ChatUser cu : myChats) {
            for (ChatUser cc : chats) {
                if (cu.getChat().equals(cc.getChat())) {
                    return "redirect:/chats";
                }
            }
        }
        var chat = Chat.builder()
                .created_at(OffsetDateTime.now())
                .name(name)
                .build();
        chatRepository.save(chat);

        var chatUser = ChatUser.builder()
                .user(user.get())
                .chat(chat)
                .build();
        chatUserRepository.save(chatUser);
        var chatUserSecond = ChatUser.builder()
                .chat(chat)
                .user(userRepository.findById(id).get())
                .build();
        chatUserRepository.save(chatUserSecond);
        return "redirect:/chats";
    }
}


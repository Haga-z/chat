package kg.chat.demo.DTO;

import kg.chat.demo.model.Chat;
import kg.chat.demo.model.ChatUser;
import kg.chat.demo.model.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class ChatUserDTO {
    private Integer id;
    private UserDTO user;
    private ChatDTO chat;

    public static ChatUserDTO from(ChatUser chatUser) {
        return builder()
                .id(chatUser.getId())
                .chat(ChatDTO.from(chatUser.getChat()))
                .user(UserDTO.from(chatUser.getUser()))
                .build();
    }
}

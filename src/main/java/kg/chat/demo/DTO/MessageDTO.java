package kg.chat.demo.DTO;

import kg.chat.demo.model.Message;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class MessageDTO {
    private Integer id;
    private ChatDTO chat;
    private String text;
    private UserDTO user;
    private boolean delivered;
    private OffsetDateTime created_at;

    public static MessageDTO from(Message message) {
        return builder()
                .chat(ChatDTO.from(message.getChat()))
                .created_at(message.getCreated_at())
                .delivered(message.isDelivered())
                .user(UserDTO.from(message.getUser()))
                .id(message.getId())
                .text(message.getText())
                .build();
    }
}

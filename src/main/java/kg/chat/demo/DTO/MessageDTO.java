package kg.chat.demo.DTO;

import kg.chat.demo.model.Chat;
import kg.chat.demo.model.Message;
import kg.chat.demo.model.User;
import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class MessageDTO {
    private Integer id;
    private Chat chat;
    private String text;
    private OffsetDateTime created_at;

    public static MessageDTO from(Message message) {
        return builder()
                .chat(message.getChat())
                .created_at(message.getCreated_at())
                .id(message.getId())
                .text(message.getText())
                .build();
    }
}

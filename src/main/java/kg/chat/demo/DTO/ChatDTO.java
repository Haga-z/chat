package kg.chat.demo.DTO;

import kg.chat.demo.model.Chat;
import lombok.*;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class ChatDTO {
    private Integer id;
    private String name;

    public static ChatDTO from(Chat chat) {
        return builder()
                .id(chat.getId())
                .name(chat.getName())
                .build();
    }
}

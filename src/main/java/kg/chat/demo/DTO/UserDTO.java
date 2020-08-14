package kg.chat.demo.DTO;

import kg.chat.demo.model.User;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class UserDTO {
    private Integer id;
    private String username;
    private OffsetDateTime created_at;

    public static UserDTO from(User user){
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .created_at(user.getCreated_at())
                .build();
    }
}

package kg.chat.demo.service;

import kg.chat.demo.DTO.MessageDTO;
import kg.chat.demo.Repositories.MessageRepository;
import kg.chat.demo.Repositories.UserRepository;
import kg.chat.demo.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository mr;
    private final UserRepository ur;

    public MessageDTO getMessage(Integer id, Principal principal) {
        List<Message> messages = mr.findAllByChatIdAndUserIdIsNot(id,ur.findByUsername(principal.getName()).get().getId());
        if (!messages.isEmpty()) {
            for (Message m : messages) {
                if (m.isDelivered() == false) {
                    m.setDelivered(true);
                    mr.save(m);
                    return MessageDTO.from(m);
                }
            }
        }else {
            return null;
        }
        return null;
    }
}

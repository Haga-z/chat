package kg.chat.demo.Repositories;

import kg.chat.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllByChatIdAndUserIdIsNot(Integer chat,Integer id);
    List<Message> findAllByChatId(Integer chat);
}

package kg.chat.demo.Repositories;

import kg.chat.demo.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatUserRepository extends JpaRepository<ChatUser,Integer> {
    List<ChatUser> findAllByUserId(Integer id);
}

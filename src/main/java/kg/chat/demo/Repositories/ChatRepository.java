package kg.chat.demo.Repositories;

import kg.chat.demo.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
}

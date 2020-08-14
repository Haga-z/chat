package kg.chat.demo.Repositories;

import kg.chat.demo.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
}

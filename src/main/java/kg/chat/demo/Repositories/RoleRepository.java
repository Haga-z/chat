package kg.chat.demo.Repositories;

import kg.chat.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findAll();
    Role findByName(String name);
}

package song.stomp1.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import song.stomp1.controller.entity.Chat;

@Repository
public interface ChatJpaRepository extends JpaRepository<Chat, Long> {

}

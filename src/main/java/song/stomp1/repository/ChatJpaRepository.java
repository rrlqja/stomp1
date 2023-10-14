package song.stomp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import song.stomp1.entity.Chat;

@Repository
public interface ChatJpaRepository extends JpaRepository<Chat, Long> {

}

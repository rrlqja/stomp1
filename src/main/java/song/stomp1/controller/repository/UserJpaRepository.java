package song.stomp1.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import song.stomp1.controller.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
    
}

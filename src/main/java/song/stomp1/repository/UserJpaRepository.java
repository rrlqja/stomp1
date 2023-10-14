package song.stomp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import song.stomp1.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
    
}

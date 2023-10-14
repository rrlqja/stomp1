package song.stomp1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import song.stomp1.entity.User;
import song.stomp1.repository.UserJpaRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userRepository;

    @Transactional
    public Long save(User user) {

        User saveUser = userRepository.save(user);

        return saveUser.getId();
    }
}

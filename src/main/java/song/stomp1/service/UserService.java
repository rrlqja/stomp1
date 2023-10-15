package song.stomp1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import song.stomp1.entity.User;
import song.stomp1.repository.UserJpaRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User saveUser = userRepository.save(user);

        return saveUser.getId();
    }
}

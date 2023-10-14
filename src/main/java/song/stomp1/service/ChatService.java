package song.stomp1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import song.stomp1.entity.Chat;
import song.stomp1.repository.ChatJpaRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatJpaRepository chatRepository;

    @Transactional
    public Long save(Chat chat) {

        Chat saveChat = chatRepository.save(chat);

        return saveChat.getId();
    }
}

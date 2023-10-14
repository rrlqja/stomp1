package song.stomp1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import song.stomp1.entity.Chatroom;
import song.stomp1.repository.ChatroomJpaRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatroomService {

    private final ChatroomJpaRepository chatroomRepository;

    @Transactional
    public Long save(Chatroom chatroom) {

        Chatroom saveChatroom = chatroomRepository.save(chatroom);

        return saveChatroom.getId();
    }
}

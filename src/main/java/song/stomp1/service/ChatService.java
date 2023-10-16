package song.stomp1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import song.stomp1.dto.ChatDto;
import song.stomp1.entity.Chat;
import song.stomp1.entity.Chatroom;
import song.stomp1.entity.User;
import song.stomp1.repository.ChatJpaRepository;
import song.stomp1.repository.ChatroomJpaRepository;
import song.stomp1.repository.UserJpaRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatJpaRepository chatRepository;
    private final UserJpaRepository userRepository;
    private final ChatroomJpaRepository chatroomRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public Long save(Chat chat) {

        Chat saveChat = chatRepository.save(chat);

        return saveChat.getId();
    }

    @Transactional
    public String saveChatting(Message<String> message, Long userId, Long chatroomId) {
        User findUser = getUser(userId);
        Chatroom findChatroom = getChatroom(chatroomId);
        String content = getContent(message);

        Chat chat = new Chat();
        chat.setContent(content);
        chat.setUser(findUser);
        chat.setChatroom(findChatroom);

        Chat saveChat = chatRepository.save(chat);
        log.info("[save chat] chatId = {}, userId = {}, chatroomId = {}", saveChat.getId(), findUser.getId(), findChatroom.getId());

        String saveChatJson = getSaveChatJson(saveChat);
        return saveChatJson;
    }

    private String getSaveChatJson(Chat saveChat) {
        String jsonContent = null;
        ChatDto chatDto = new ChatDto(saveChat);
        try {
            jsonContent = objectMapper.writeValueAsString(chatDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("메시지 파싱 에러");
        }
        return jsonContent;
    }

    private String getContent(Message<String> message) {
        String content = null;

        try {
            content = objectMapper.readTree(message.getPayload()).get("content").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("메시지 파싱 에러");
        }

        return content;
    }

    private Chatroom getChatroom(Long chatroomId) {
        return chatroomRepository.findById(chatroomId).orElseThrow(() -> new RuntimeException("채팅방 없음."));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("사용자 없음."));
    }
}

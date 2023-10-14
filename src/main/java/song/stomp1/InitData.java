package song.stomp1;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import song.stomp1.entity.Chatroom;
import song.stomp1.entity.User;
import song.stomp1.service.ChatroomService;
import song.stomp1.service.UserService;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitData {

    private final Init init;

    @PostConstruct
    public void doInit() {
        init.setInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    private static class Init {

        private final UserService userService;
        private final ChatroomService chatroomService;

        public void setInit() {

            User user = new User();
            user.setUsername("a");
            user.setPassword("a");
            Long userId = userService.save(user);

            Chatroom chatroom = new Chatroom();
            chatroom.setUser(user);
            chatroom.setName("chatA");
            chatroomService.save(chatroom);
        }
    }
}

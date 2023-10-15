package song.stomp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import song.stomp1.security.UserDetailsImpl;
import song.stomp1.service.ChatService;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StompController {

    private final ChatService chatService;

    @MessageMapping("/chat/{chatroomId}")
    public String chatMessage(@DestinationVariable(value = "chatroomId") Long chatroomId,
                              Message<String> message,
                              Principal principal) {
        log.info("message = {}", message.getPayload());

        UserDetailsImpl userDetails = getUserDetails(principal);
        Long userId = userDetails.getId();

        String saveMessage = chatService.saveChatting(message, userId, chatroomId);

        return saveMessage;
    }

    private static UserDetailsImpl getUserDetails(Principal principal) {
        return (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}

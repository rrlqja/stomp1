package song.stomp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StompController {

    @MessageMapping("/chat/{id}")
    public String chatMessage(@DestinationVariable(value = "id") Long id) {

        return "hello world!";
    }
}

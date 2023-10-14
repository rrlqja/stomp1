package song.stomp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import song.stomp1.dto.ChatroomDto;
import song.stomp1.service.ChatroomService;

@Slf4j
@Controller
@RequestMapping("/chatroom")
@RequiredArgsConstructor
public class ChatroomController {

    private final ChatroomService chatroomService;

    @GetMapping("/{id}")
    public String getChatroom(@PathVariable(name = "id") Long id,
                              Model model) {
        ChatroomDto chatroomDto = chatroomService.getChatroom(id);

        model.addAttribute("chatroomDto", chatroomDto);

        return "/chatroom/chatroom";
    }
}

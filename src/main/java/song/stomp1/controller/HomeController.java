package song.stomp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import song.stomp1.dto.LoginDto;
import song.stomp1.entity.Chatroom;
import song.stomp1.service.ChatroomService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ChatroomService chatroomService;

    @GetMapping("/")
    public String getHome(@PageableDefault Pageable pageable,
                          Model model) {

        Page<Chatroom> chatroomPage = chatroomService.getChatroom(pageable);

        model.addAttribute("chatroomPage", chatroomPage);

        return "/home";
    }

    @GetMapping("/login")
    public String getLogin(@ModelAttribute LoginDto loginDto) {

        return "/login";
    }
}

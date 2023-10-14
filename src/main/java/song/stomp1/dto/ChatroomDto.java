package song.stomp1.dto;

import lombok.Getter;
import lombok.Setter;
import song.stomp1.entity.Chatroom;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ChatroomDto {

    private Long id;
    private String name;

    private Long userId;
    private String username;

    private List<ChatDto> chatDtoList = new ArrayList<>();

    public ChatroomDto(Chatroom chatroom) {
        this.id = chatroom.getId();
        this.name = chatroom.getName();
        this.userId = chatroom.getUser().getId();
        this.username = chatroom.getUser().getUsername();
        this.chatDtoList = chatroom.getChatList().stream().map(ChatDto::new).toList();
    }
}

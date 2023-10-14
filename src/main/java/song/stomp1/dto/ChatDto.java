package song.stomp1.dto;

import lombok.Getter;
import lombok.Setter;
import song.stomp1.entity.Chat;

@Getter @Setter
public class ChatDto {
    private Long id;
    private String content;

    private Long chatroomId;

    private Long userId;
    private String username;


    public ChatDto(Chat chat) {
        this.id = chat.getId();
        this.content = chat.getContent();
        this.chatroomId = chat.getChatroom().getId();
        this.userId = chat.getUser().getId();
        this.username = chat.getUser().getUsername();
    }
}

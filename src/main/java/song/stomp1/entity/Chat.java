package song.stomp1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Chat extends BaseTimeEntity{

    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "chatroom_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Chatroom chatroom;

    private String content;
}

package song.stomp1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Chatroom {

    @Id @GeneratedValue
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    private String name;

    @OneToMany(mappedBy = "chatroom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chat> chatList = new ArrayList<>();
}

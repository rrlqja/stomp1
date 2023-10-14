package song.stomp1.dto;

import lombok.Getter;
import lombok.Setter;
import song.stomp1.entity.User;

@Getter @Setter
public class UserDto {
    private Long id;
    private String username;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}

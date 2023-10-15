package song.stomp1.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;

import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
public class InChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        Object payload = message.getPayload();

        String content = null;
        if (payload instanceof byte[]) {
            content = new String((byte[]) payload, StandardCharsets.UTF_8);
            content = content.replaceAll("시발", "***");
        }

        Message<String> newMessage = MessageBuilder.withPayload(content)
                .copyHeaders(message.getHeaders())
                .build();

        return newMessage;
    }
}

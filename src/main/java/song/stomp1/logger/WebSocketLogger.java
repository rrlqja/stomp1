package song.stomp1.logger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketLogger {

    private final WebSocketMessageBrokerStats webSocketMessageBrokerStats;

    @Scheduled(fixedRate = 5000)
    public void logWebSocketStatus() {
        log.info(webSocketMessageBrokerStats.toString());
    }
}

package song.stomp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Stomp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Stomp1Application.class, args);
	}

}

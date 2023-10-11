package song.stomp1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .formLogin(login -> login
                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .successForwardUrl("/")
                                .failureForwardUrl("/login")
//                        .successHandler()
//                        .failureHandler()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll())
                .authorizeHttpRequests(authorization -> authorization
                        .requestMatchers("/", "/login", "logout", "/signup", "/css/**", "/*.ico", "/*.js", "/error").permitAll()
                        .anyRequest().permitAll())
                .build();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

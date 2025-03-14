package dzamsheed.uz.auth_service.component;

import dzamsheed.uz.auth_service.module.users.User;
import dzamsheed.uz.auth_service.module.users.UserRepository;
import dzamsheed.uz.auth_service.module.users.UserRole;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    ApplicationRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(
                        User
                                .builder()
                                .role(UserRole.ADMIN)
                                .username("admin")
                                .password(passwordEncoder.encode("admin"))
                                .build()
                );

                userRepository.save(
                        User
                                .builder()
                                .role(UserRole.USER)
                                .username("user")
                                .password(passwordEncoder.encode("user"))
                                .build()
                );
            }
        };
    }
}

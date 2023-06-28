package app.car.appcarapi.config;

import app.car.appcarapi.domain.User;
import app.car.appcarapi.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class LoadUserConfig {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        User admin = new User();
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setRoles(Arrays.asList("ROLE_ADMIN"));
        admin.setUsername("admin");
        admin.setEnable(true);
        userRepository.save(admin);
    }
}

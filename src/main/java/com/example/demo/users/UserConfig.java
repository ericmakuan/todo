package com.example.demo.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerU(UserRepository repository) {
        return args -> {
            Users ma = new Users("Maria",
                    "ma@gm.com"
            );
            Users al = new Users("Alex",
                    "al@cm.com"
            );

            repository.saveAll(
                    List.of(ma, al)
            );
        };
    }
}

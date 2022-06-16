package com.example.demo.userList;

import com.example.demo.todo.Todo;
import com.example.demo.todo.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerU(UserRepository repository) {
        return args -> {
            UserList ma = new UserList("Maria",
                    "ma@gm.com"
            );
            UserList al = new UserList("Alex",
                    "al@cm.com"
            );

            repository.saveAll(
                    List.of(ma, al)
            );
        };
    }
}

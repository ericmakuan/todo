package com.example.demo.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


@Configuration
public class TodoConfig {
    LocalDateTime local = LocalDateTime.now();
    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository) {
        return args -> {
            Todo sleep = new Todo("sleep", new Date(2022, 7, 1), "high", 1L
            );
            Todo learn = new Todo("learn", new Date(2022, 8, 1), "high", 1L
            );

            repository.saveAll(
                    List.of(sleep, learn)
            );
        };
    }
}

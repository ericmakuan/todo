package com.example.demo.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.example.demo.todo.Priority.HIGH;
import static com.example.demo.todo.Priority.LOW;


@Configuration
public class TodoConfig {
    LocalDateTime local = LocalDateTime.now();

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository) {
        return args -> {
            Todo sleep = new Todo("sleep", new Date(2022, 7, 1), HIGH, 1L, "Maria"
            );
            Todo learn = new Todo("learn", new Date(2022, 8, 1), HIGH, 2L, "Alex"
            );
            Todo sleep1 = new Todo("sleep1", new Date(2022, 7, 1), HIGH, 1L, "Maria"
            );
            Todo sleep2 = new Todo("sleep2", new Date(2022, 7, 1), HIGH, 1L, "Maria"
            );
            Todo sleep3 = new Todo("sleep3", new Date(2022, 7, 1), HIGH, 1L, "Maria"
            );
            Todo sleep4 = new Todo("sleep4", new Date(2022, 7, 1), HIGH, 1L, "Maria"
            );
            Todo sleep5 = new Todo("sleep5", new Date(2022, 7, 1), HIGH, 1L, "Maria"
            );
            Todo sleep6 = new Todo("sleep6", new Date(2022, 7, 1), LOW, 1L, "Maria"
            );

            repository.saveAll(
                    List.of(sleep, learn, sleep1, sleep2, sleep3, sleep4, sleep5, sleep6)
            );
        };
    }
}

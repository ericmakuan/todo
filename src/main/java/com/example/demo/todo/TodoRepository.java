package com.example.demo.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("SELECT s FROM Todo s WHERE s.name = ?1 ORDER BY s.deadLine")
    Optional<Todo> findTodoBYName(String name);
}

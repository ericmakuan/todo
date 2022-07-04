package com.example.demo.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("SELECT s FROM Todo s WHERE s.name = ?1 ORDER BY s.deadLine")
    Optional<Todo> findTodoBYName(String name);

    @Query("SELECT s FROM Todo s WHERE s.name = ?1 ORDER BY s.deadLine")
    List<Todo> findTodoByName(String name);

    @Query("SELECT s FROM Todo s WHERE s.userId = ?1 ORDER BY s.deadLine")
    List<Todo> findTodoBYUser(Long userId);

    @Query("SELECT s FROM Todo s WHERE s.userName = ?1 ORDER BY s.deadLine")
    List<Todo> findTodoByUserName(String userName);

    Page<Todo> findTodoByUserName(String userName, Pageable pageable);
}

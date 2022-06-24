package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos () {
        return todoRepository.findAll();
    }
    public List<Todo> getTodo (Long todoId) {

        return todoRepository.findAllById(Collections.singleton(todoId));
    }

    public List<Todo> addNewTodo(Todo todo) {
        Optional<Todo> todoOptional = todoRepository.findTodoBYName(todo.getName());
        if (todoOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        todo.setDone("undone");
        todoRepository.save(todo);
        return getTodos();
    }

    public List<Todo> deleteTodo(Long todoId) {
        boolean exists = todoRepository.existsById(todoId);
        if (!exists) {
            throw new IllegalStateException("todo with id " + todoId + "does not exists");

        }
        todoRepository.deleteById(todoId);
        return getTodos();
    }

    @Transactional
    public List<Todo> updateTodo(Long todoId, String done) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalStateException("Todo with id " + todoId + "does not exists")
                );
        todo.setDone(done);
        return getTodos();


    }
}

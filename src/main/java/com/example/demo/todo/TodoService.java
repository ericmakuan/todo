package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;


    Pageable firstPageWithFiveElements = PageRequest.of(1, 5);

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodo(Long todoId) {

        return todoRepository.findAllById(Collections.singleton(todoId));
    }

    public List<Todo> getTodosByUser(Long userId) {

        return todoRepository.findTodoBYUser(userId);
    }

    public Page<Todo> getTodosByUserName(String userName, int page, int size) {
//        return todoRepository.findTodoByUserName(userName);
        System.out.println(todoRepository.findTodoByUserName(userName, PageRequest.of(page, size)));
        Page<Todo> result = todoRepository.findTodoByUserName(userName, PageRequest.of(page, size));
        return result;
    }

    public List<Todo> addNewTodo(Todo todo) {
        Optional<Todo> todoOptional = todoRepository.findTodoBYName(todo.getName());
        if (todoOptional.isPresent()) {
            return todoRepository.findTodoByUserName(todo.getUserName());
        }
        todo.setDone("undone");
        todoRepository.save(todo);
        return todoRepository.findTodoByUserName(todo.getUserName());

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
        return todoRepository.findTodoByUserName(todo.getUserName());
    }
}

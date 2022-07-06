package com.example.demo.todo;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@Controller
@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello World!!!");
        return "hello";
    }

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }


    @GetMapping(path = "{todoId}")
    public List<Todo> getTodo(@PathVariable("todoId") Long todoId) {
        return todoService.getTodo(todoId);
    }


    @PostMapping
    public void generateNewTodo(@RequestBody Todo todo) {

        todoService.addNewTodoC(todo);
    }

    @DeleteMapping(path = "{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {

        todoService.deleteTodo(todoId);
    }

    @PutMapping(path = "{todoId}")
    public void updateTodo(@PathVariable("todoId") Long todoId,
                           @RequestParam(required = false) String done) {
        todoService.updateTodo(todoId, done);
    }
}

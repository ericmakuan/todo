package com.example.demo;

import com.example.demo.todo.Todo;
import com.example.demo.todo.TodoRepository;
import com.example.demo.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class ViewController {
    TodoRepository todoRepository;
    @GetMapping("index")
    public String getindex(Model model) {
        model.addAttribute("name","eric");
        return "list";
    }

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public String getTodos(Model model) {
        Iterable<Todo> todoList = todoService.getTodos();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "list";
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo, Model model) {
        Iterable<Todo> allTodoList = todoService.addNewTodo(todo);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "redirect:/todos";
    }
    @ResponseBody
    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@ModelAttribute Todo todo, Model model, @PathVariable("todoId") Long todoId) {
        System.out.println(todo);
        Iterable<Todo> allTodoList = todoService.deleteTodo(todoId);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "list";
    }

    @ResponseBody
    @PutMapping ("/todos/{todoId}")
    public String putTodo(@ModelAttribute Todo todo, Model model, @PathVariable("todoId") Long todoId) {
        System.out.println(todo);
        Iterable<Todo> allTodoList = todoService.updateTodo(todoId,"done");
        model.addAttribute("todolist", allTodoList);
        return "list";
    }


}

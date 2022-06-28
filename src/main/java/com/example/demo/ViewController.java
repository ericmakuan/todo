package com.example.demo;

import com.example.demo.todo.Todo;
import com.example.demo.todo.TodoRepository;
import com.example.demo.todo.TodoService;
import com.example.demo.users.UserService;
import com.example.demo.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class ViewController {
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @Autowired
    UserService userService;

    @GetMapping("/todos")
    public String getTodos(Model model) {
        Iterable<Todo> todoList = todoService.getTodos();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "list";
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo, Users user, Model model) {
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
    @GetMapping("/users")
    public String usersPage(Model model) {
        Iterable<Users> userList = userService.getUsers();
        model.addAttribute("userlist", userList);
        Users user = new Users();
        model.addAttribute("usersObject", user);
        return "userSign";
    }

    @PostMapping("/users")
    public String createUsers(@ModelAttribute Users users, Model model) {
        Iterable<Todo> todoList = todoService.getTodos();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        Iterable<Users> theUser = userService.addNewUser(users);
        Users emptyUser = new Users();
        model.addAttribute("userlist", theUser);
        model.addAttribute("usersObject", emptyUser);
        return "list";
    }

    @ResponseBody
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@ModelAttribute Users user, Model model, @PathVariable("userId") Long userId) {
        Iterable<Users> userList = userService.deleteUser(userId);
        model.addAttribute("userlist", userList);
        Users users = new Users();
        model.addAttribute("usersObject", users);
        return "redirect:/users";
    }
}

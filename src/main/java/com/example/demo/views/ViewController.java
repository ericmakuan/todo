package com.example.demo.views;

import com.example.demo.todo.Todo;
import com.example.demo.todo.TodoService;
import com.example.demo.users.UserService;
import com.example.demo.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    TodoService todoService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String frontPage(Model model) {
        Users user = new Users();
        model.addAttribute("usersObject", user);
        return "userSign";
    }

    @GetMapping("/todos")
    public String getTodos(Model model) {
        Iterable<Todo> todoList = todoService.getTodos();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "list";
    }

    @PostMapping("/todos")
    public String createTodo(@RequestParam(defaultValue = "0") Integer page,
                             @RequestParam(defaultValue = "5") Integer size,
                             @ModelAttribute Todo todo, Users user, Model model) {
        Page<Todo> todoList = todoService.addNewTodo(todo, page, size);
        int pageNums = todoList.getTotalPages();
        model.addAttribute("pageNums", pageNums);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", todoList);
        model.addAttribute("todoObject", emptyTodo);
        Iterable<Users> theUser = userService.getUserByName(todo.getUserName());
        Users emptyUser = new Users();
        model.addAttribute("userlist", theUser);
        model.addAttribute("usersObject", emptyUser);
        return "list";
    }

    @ResponseBody
    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@ModelAttribute Todo todo, Model model, @PathVariable("todoId") Long todoId) {
        System.out.println(todoId);
        Iterable<Todo> allTodoList = todoService.deleteTodo(todoId);
        System.out.println(allTodoList);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        Iterable<Users> theUser = userService.getUserByName(todo.getUserName());
        Users emptyUser = new Users();
        model.addAttribute("userlist", theUser);
        model.addAttribute("usersObject", emptyUser);
        return "list";
    }

    @ResponseBody
    @PutMapping("/todos/{todoId}")
    public String putTodo(@ModelAttribute Todo todo, Model model, @PathVariable("todoId") Long todoId) {
        Iterable<Todo> allTodoList = todoService.updateTodo(todoId, "done");
        model.addAttribute("todolist", allTodoList);
        Iterable<Users> theUser = userService.getUserByName(todo.getUserName());
        Users emptyUser = new Users();
        model.addAttribute("userlist", theUser);
        model.addAttribute("usersObject", emptyUser);
        return "redirect:/userTodo";
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
    public String createUsers(@RequestParam(defaultValue = "0") Integer page,
                              @RequestParam(defaultValue = "5") Integer size,
                              @ModelAttribute Users users, Model model) {
        Iterable<Users> theUser = userService.addNewUser(users);
        Page<Todo> todoList = todoService.getTodosByUserName(users.getName(), page, size);
        int pageNums = todoList.getTotalPages();
        model.addAttribute("pageNums", pageNums);
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
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


    @RequestMapping(value = "/userTodo")
    public String getUserTodo(@RequestParam(defaultValue = "0") Integer page,
                              @RequestParam(defaultValue = "5") Integer size, Users user, Model model) {
        Iterable<Users> theUser = userService.getUserByName(user.getName());
        Users emptyUser = new Users();
        model.addAttribute("userlist", theUser);
        model.addAttribute("usersObject", emptyUser);
        Page<Todo> todoList = todoService.getTodosByUserName(user.getName(), page, size);
        int pageNums = todoList.getTotalPages();
        model.addAttribute("pageNums", pageNums);
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "list";
    }
    

}

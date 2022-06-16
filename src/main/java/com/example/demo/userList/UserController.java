package com.example.demo.userList;


import com.example.demo.userList.UserList;
import com.example.demo.userList.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/userlist")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    public List<UserList> getUsers () {
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public List<UserList> getUser (@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public void generateNewUser(@RequestBody UserList userList) {

        userService.addNewUser(userList);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {

        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String user){
        userService.updateUser(userId, name, user);
    }
}

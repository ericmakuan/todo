package com.example.demo.userList;

import javax.persistence.*;


@Entity
@Table
public class UserList {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private Long todoId;

    public UserList() {
    }

    public UserList(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserList(Long id, String name, String email, Long todoId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.todoId = todoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", todoId=" + todoId +
                '}';
    }
}

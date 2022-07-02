package com.example.demo.users;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table
public class Users {
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
    @Email
    private String email;
    private Long todoId;

    public Users() {
    }

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Users(Long id, String name, String email, Long todoId) {
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

package com.example.demo.todo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Todo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;

    private String name;
    private String done;
    private Date deadLine;
    private Priority priority;
    private Long userId;

    private String userName;

    public Todo() {

    }

//    public Todo(Long id, String name, String done, Date deadLine, String priority, Long userId) {
//        this.id = id;
//        this.name = name;
//        this.done = done;
//        this.deadLine = deadLine;
//        this.priority = priority;
//        this.userId = userId;
//    }

    public Todo(String name, Date deadLine, Priority priority, Long userId, String userName) {

        this.name = name;
        this.done = "undone";
        this.deadLine = deadLine;
        this.priority = priority;
        this.userId = userId;
        this.userName = userName;
    }


//    public Todo(String name, String done) {
//        this.name = name;
//        this.done = done;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", done='" + done + '\'' +
                ", deadLine=" + deadLine +
                ", priority='" + priority + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

}

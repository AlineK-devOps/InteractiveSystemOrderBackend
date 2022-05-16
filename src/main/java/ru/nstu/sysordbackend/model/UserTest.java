package ru.nstu.sysordbackend.model;

import ru.nstu.sysordbackend.entity.UserEntityTest;

import java.util.List;
import java.util.stream.Collectors;

public class UserTest {
    private Long id;
    private String login;
    private String name;
    private List<Todo> todos;

    public static UserTest toModel(UserEntityTest entity){
        UserTest model = new UserTest();
        model.setId(entity.getId());
        model.setLogin(entity.getLogin());
        model.setName(entity.getName());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));

        return model;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

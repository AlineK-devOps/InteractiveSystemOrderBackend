package ru.nstu.sysordbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nstu.sysordbackend.entity.TodoEntity;
import ru.nstu.sysordbackend.entity.UserEntity;
import ru.nstu.sysordbackend.exception.TodoNotFoundException;
import ru.nstu.sysordbackend.exception.UserNotFoundException;
import ru.nstu.sysordbackend.model.Todo;
import ru.nstu.sysordbackend.repository.TodoRepository;
import ru.nstu.sysordbackend.repository.UserRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    UserRepository userRepository;

    public Todo createTodo(TodoEntity todo, Long userId) throws UserNotFoundException {
        if (userRepository.findById(userId).isPresent()){
            UserEntity user = userRepository.findById(userId).get();
            todo.setUser(user);
            return Todo.toModel(todoRepository.save(todo));
        }
        else throw new UserNotFoundException("Пользователь не найден");
    }

    public Todo completeTodo(Long todoId) throws TodoNotFoundException {
        if (todoRepository.findById(todoId).isPresent()){
            TodoEntity todo = todoRepository.findById(todoId).get();
            todo.setCompleted(!todo.getCompleted());
            return Todo.toModel(todoRepository.save(todo));
        }
        else throw new TodoNotFoundException("Задача не была найдена");
    }
}

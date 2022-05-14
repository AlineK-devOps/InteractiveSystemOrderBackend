package ru.nstu.sysordbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.nstu.sysordbackend.entity.TodoEntity;
import ru.nstu.sysordbackend.exception.TodoNotFoundException;
import ru.nstu.sysordbackend.exception.UserNotFoundException;
import ru.nstu.sysordbackend.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){
        try{
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (UserNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long todoId){
        try{
            return ResponseEntity.ok(todoService.completeTodo(todoId));
        } catch (TodoNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

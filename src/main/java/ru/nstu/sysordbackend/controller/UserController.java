package ru.nstu.sysordbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nstu.sysordbackend.entity.UserEntity;
import ru.nstu.sysordbackend.exception.UserAlreadyExistException;
import ru.nstu.sysordbackend.exception.UserNotFoundException;
import ru.nstu.sysordbackend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно добавлен!");
        } catch (UserAlreadyExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

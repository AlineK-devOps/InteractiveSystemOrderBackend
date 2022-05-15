package ru.nstu.sysordbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nstu.sysordbackend.exception.CategoryNotFoundException;
import ru.nstu.sysordbackend.service.MenuService;

@RestController
@RequestMapping("/api/dishes")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/sushi")
    public ResponseEntity getSushiMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(1L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/rolls")
    public ResponseEntity getRollsMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(2L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/hot_rolls")
    public ResponseEntity getHotRollsMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(3L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/snacks")
    public ResponseEntity getSnacksMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(4L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/wok")
    public ResponseEntity getWokMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(5L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/soups")
    public ResponseEntity getSoupsMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(6L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/drinks")
    public ResponseEntity getDrinksMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(7L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/additionally")
    public ResponseEntity getAdditionallyMenu(){
        try {
            return ResponseEntity.ok(menuService.getMenuByCategory(8L));
        } catch (CategoryNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
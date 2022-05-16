package ru.nstu.sysordbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nstu.sysordbackend.model.OrderModel;
import ru.nstu.sysordbackend.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderModel order){
        try{
            orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

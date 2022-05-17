package ru.nstu.sysordbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nstu.sysordbackend.model.OrderModel;
import ru.nstu.sysordbackend.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity createOrder(@RequestBody OrderModel order){
        try{
            orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/cook/orders")
    public ResponseEntity getOrdersForCook(){
        try {
            return ResponseEntity.ok(orderService.getOrdersForCook());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/cook/orders/hot_workshop")
    public ResponseEntity getHotWorkshopOrdersForCook(){
        try {
            return ResponseEntity.ok(orderService.getHotWorkshopOrdersForCook());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/cook/orders/cold_workshop")
    public ResponseEntity getColdWorkshopOrdersForCook(){
        try {
            return ResponseEntity.ok(orderService.getColdWorkshopOrdersForCook());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/cook/orders/bar")
    public ResponseEntity getBarOrdersForCook(){
        try {
            return ResponseEntity.ok(orderService.getBarOrdersForCook());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/waiter/orders")
    public ResponseEntity getOrdersForWaiter(){
        try {
            return ResponseEntity.ok(orderService.getOrdersForWaiter());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

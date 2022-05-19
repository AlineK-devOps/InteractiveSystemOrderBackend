package ru.nstu.sysordbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nstu.sysordbackend.model.cook.StatusUpdateForCookModel;
import ru.nstu.sysordbackend.model.customer.OrderForCustomer;
import ru.nstu.sysordbackend.model.waiter.StatusUpdateForWaiterModel;
import ru.nstu.sysordbackend.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity createOrder(@RequestBody OrderForCustomer order){
        try{
            orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/cook/update_status")
    public ResponseEntity updateStatus(@RequestBody StatusUpdateForCookModel item){
        try{
            orderService.updateStatus(item);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/waiter/update_status")
    public ResponseEntity updateStatusForWaiter(@RequestBody StatusUpdateForWaiterModel item){
        try{
            orderService.updateStatusForWaiter(item);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/waiter/calling/{tableId}")
    public ResponseEntity doneWaiterCalling(@PathVariable Long tableId){
        try {
            orderService.doneWaiterCalling(tableId);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/waiter_call/{tableId}")
    public ResponseEntity createWaiterCalling(@PathVariable Long tableId){
        try {
            orderService.createWaiterCalling(tableId);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/waiter/done_order/{tableId}")
    public ResponseEntity doneOrder(@PathVariable Long tableId){
        try {
            orderService.doneOrder(tableId);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/waiter/delete/dish/{positionId}")
    public ResponseEntity deleteDishFromOrder(@PathVariable Long positionId){
        try {
            orderService.deleteDishFromOrder(positionId);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/waiter/delete/order/{tableId}")
    public ResponseEntity deleteOrder(@PathVariable Long tableId){
        try {
            orderService.deleteOrder(tableId);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception ex) {
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

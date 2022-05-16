package ru.nstu.sysordbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nstu.sysordbackend.entity.*;
import ru.nstu.sysordbackend.model.OrderItemModel;
import ru.nstu.sysordbackend.model.OrderModel;
import ru.nstu.sysordbackend.repository.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private DishesRepository dishesRepository;
    public void createOrder(OrderModel order) {
        OrderEntity orderEntity;
        List<OrderItemEntity> orderList;

        if (orderRepository.findByTableId(order.getTableId()).isPresent()){
            orderEntity = orderRepository.findByTableId(order.getTableId()).get();
            orderList = orderEntity.getOrderItems();
        }
        else{
            orderEntity = new OrderEntity();
            orderList = new ArrayList<>();

            orderEntity.setTable(userRepository.findById(order.getTableId()).get());
            orderEntity.setOrderItems(orderList);

            orderRepository.save(orderEntity);
        }

        for (OrderItemModel itemModel : order.getOrder()){
            for (int i = 0; i < itemModel.getCount(); i++){
                OrderItemEntity itemEntity = new OrderItemEntity();

                itemEntity.setOrder(orderRepository.findByTableId(order.getTableId()).get());
                itemEntity.setDish(dishesRepository.findById(itemModel.getDishId()).get());
                itemEntity.setStatus(new OrderItemStatusEntity(1L, "IN_QUEUE_FOR_COOKING"));

                orderList.add(itemEntity);
            }
        }
        orderEntity.setOrderItems(orderList);
        orderRepository.save(orderEntity);
    }
}

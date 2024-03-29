package ru.nstu.sysordbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nstu.sysordbackend.entity.order.OrderEntity;
import ru.nstu.sysordbackend.entity.order.OrderItemEntity;
import ru.nstu.sysordbackend.entity.order.OrderItemStatusEntity;
import ru.nstu.sysordbackend.model.cook.OrderForCook;
import ru.nstu.sysordbackend.model.cook.OrderItemForCook;
import ru.nstu.sysordbackend.model.cook.StatusUpdateForCookModel;
import ru.nstu.sysordbackend.model.customer.OrderForCustomer;
import ru.nstu.sysordbackend.model.customer.OrderItemForCustomer;
import ru.nstu.sysordbackend.model.waiter.OrderForWaiter;
import ru.nstu.sysordbackend.model.waiter.OrderItemForWaiter;
import ru.nstu.sysordbackend.model.waiter.StatusUpdateForWaiterModel;
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

    @Autowired
    private OrderItemStatusRepository statusRepository;

    public void createOrder(OrderForCustomer order) {
        OrderEntity orderEntity;
        List<OrderItemEntity> orderList;

        if (orderRepository.findByTableId(order.getTableId()).isPresent()) {
            orderEntity = orderRepository.findByTableId(order.getTableId()).get();
            orderList = orderEntity.getOrderItems();
        } else {
            orderEntity = new OrderEntity();
            orderList = new ArrayList<>();

            orderEntity.setTable(userRepository.findById(order.getTableId()).get());
            orderEntity.setOrderItems(orderList);

            orderRepository.save(orderEntity);
        }

        for (OrderItemForCustomer itemModel : order.getOrder()) {
            for (int i = 0; i < itemModel.getCount(); i++) {
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

    public void updateStatus(StatusUpdateForCookModel item) {
        if (orderItemRepository.findById(item.getOrderItemId()).isPresent()) {
            OrderItemEntity entity = orderItemRepository.findById(item.getOrderItemId()).get();
            entity.setCook(userRepository.findById(item.getCookId()).get());
            entity.setStatus(statusRepository.findByName(item.getStatus()));
            orderItemRepository.save(entity);
        }
    }

    public void updateStatusForWaiter(StatusUpdateForWaiterModel item) {
        if (orderItemRepository.findById(item.getOrderItemId()).isPresent()) {
            OrderItemEntity entity = orderItemRepository.findById(item.getOrderItemId()).get();
            entity.setWaiter(userRepository.findById(item.getWaiterId()).get());
            entity.setStatus(statusRepository.findByName(item.getStatus()));
            orderItemRepository.save(entity);
        }
    }

    public List<OrderForCook> getOrdersForCook() {
        List<OrderForCook> orders = new ArrayList<>();

        for (OrderEntity entity : orderRepository.findAll()) {
            OrderForCook order = new OrderForCook();

            order.setTableId(entity.getTable().getId());

            List<OrderItemForCook> itemModels = new ArrayList<>();
            for (OrderItemEntity itemEntity : entity.getOrderItems()) {
                if (itemEntity.getStatus().equals("IN_QUEUE_FOR_COOKING") || itemEntity.getStatus().equals("IN_COOKING_PROCESS"))
                    itemModels.add(OrderItemForCook.toModel(itemEntity));
            }

            if (!itemModels.isEmpty()) {
                order.setOrder(itemModels);
                orders.add(order);
            }
        }
        return orders;
    }

    public List<OrderForCook> getHotWorkshopOrdersForCook() {
        List<OrderForCook> orders = new ArrayList<>();

        for (OrderEntity entity : orderRepository.findAll()) {
            OrderForCook order = new OrderForCook();

            order.setTableId(entity.getTable().getId());

            List<OrderItemForCook> itemModels = new ArrayList<>();
            for (OrderItemEntity itemEntity : entity.getOrderItems()) {
                String category = itemEntity.getDish().getCategory();
                if ((category.equals("HOT_ROLL") || category.equals("WOK") || category.equals("SOUP"))
                        && (itemEntity.getStatus().equals("IN_QUEUE_FOR_COOKING") || itemEntity.getStatus().equals("IN_COOKING_PROCESS")))
                    itemModels.add(OrderItemForCook.toModel(itemEntity));
            }

            if (!itemModels.isEmpty()) {
                order.setOrder(itemModels);
                orders.add(order);
            }
        }
        return orders;
    }

    public List<OrderForCook> getColdWorkshopOrdersForCook() {
        List<OrderForCook> orders = new ArrayList<>();

        for (OrderEntity entity : orderRepository.findAll()) {
            OrderForCook order = new OrderForCook();

            order.setTableId(entity.getTable().getId());

            List<OrderItemForCook> itemModels = new ArrayList<>();
            for (OrderItemEntity itemEntity : entity.getOrderItems()) {
                String category = itemEntity.getDish().getCategory();
                if ((category.equals("SUSHI") || category.equals("ROLL") || category.equals("SNACK"))
                        && (itemEntity.getStatus().equals("IN_QUEUE_FOR_COOKING") || itemEntity.getStatus().equals("IN_COOKING_PROCESS")))
                    itemModels.add(OrderItemForCook.toModel(itemEntity));
            }

            if (!itemModels.isEmpty()) {
                order.setOrder(itemModels);
                orders.add(order);
            }
        }
        return orders;
    }

    public List<OrderForCook> getBarOrdersForCook() {
        List<OrderForCook> orders = new ArrayList<>();

        for (OrderEntity entity : orderRepository.findAll()) {
            OrderForCook order = new OrderForCook();

            order.setTableId(entity.getTable().getId());

            List<OrderItemForCook> itemModels = new ArrayList<>();
            for (OrderItemEntity itemEntity : entity.getOrderItems()) {
                String category = itemEntity.getDish().getCategory();
                if ((category.equals("DRINK"))
                        && (itemEntity.getStatus().equals("IN_QUEUE_FOR_COOKING") || itemEntity.getStatus().equals("IN_COOKING_PROCESS")))
                    itemModels.add(OrderItemForCook.toModel(itemEntity));
            }

            if (!itemModels.isEmpty()) {
                order.setOrder(itemModels);
                orders.add(order);
            }
        }
        return orders;
    }

    public List<OrderForWaiter> getOrdersForWaiter() {
        List<OrderForWaiter> orders = new ArrayList<>();

        for (OrderEntity entity : orderRepository.findAll()) {
            OrderForWaiter order = new OrderForWaiter();

            order.setWaiterCalled(entity.getWaiterCalled());
            order.setTableId(entity.getTable().getId());
            order.setOrder(OrderItemForWaiter.toModel(entity.getOrderItems()));

            orders.add(order);
        }
        return orders;
    }

    public void doneWaiterCalling(Long tableId) {
        if (orderRepository.findByTableId(tableId).isPresent()) {
            OrderEntity order = orderRepository.findByTableId(tableId).get();
            order.setWaiterCalled(false);
            orderRepository.save(order);
        }
    }

    public void createWaiterCalling(Long tableId) {
        if (orderRepository.findByTableId(tableId).isPresent()) {
            OrderEntity order = orderRepository.findByTableId(tableId).get();
            order.setWaiterCalled(true);
            orderRepository.save(order);
        }
    }

    public void deleteDishFromOrder(Long positionId) {
        if (orderItemRepository.findById(positionId).isPresent())
            orderItemRepository.delete(orderItemRepository.findById(positionId).get());
    }

    public void deleteOrder(Long tableId) {
        if (orderRepository.findByTableId(tableId).isPresent())
            orderRepository.delete(orderRepository.findByTableId(tableId).get());
    }

    public void doneOrder(Long tableId) {
        deleteOrder(tableId);
    }
}

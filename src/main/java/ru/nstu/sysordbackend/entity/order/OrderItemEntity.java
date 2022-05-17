package ru.nstu.sysordbackend.entity.order;

import ru.nstu.sysordbackend.entity.user.UserEntity;
import ru.nstu.sysordbackend.entity.dish.DishEntity;

import javax.persistence.*;

@Entity
@Table(name = "order_list")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dish;

    @ManyToOne
    @JoinColumn(name = "cook_id")
    private UserEntity cook;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private UserEntity waiter;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderItemStatusEntity status;

    public static OrderItemEntity toEntity(){
        OrderItemEntity entity = new OrderItemEntity();

        return entity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setDish(DishEntity dish) {
        this.dish = dish;
    }

    public void setCook(UserEntity cook) {
        this.cook = cook;
    }

    public void setWaiter(UserEntity waiter) {
        this.waiter = waiter;
    }

    public void setStatus(OrderItemStatusEntity status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public DishEntity getDish() {
        return dish;
    }

    public UserEntity getCook() {
        return cook;
    }

    public UserEntity getWaiter() {
        return waiter;
    }

    public String getStatus() {
        return status.getName();
    }
}

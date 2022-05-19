package ru.nstu.sysordbackend.entity.user;

import ru.nstu.sysordbackend.entity.order.OrderEntity;
import ru.nstu.sysordbackend.entity.order.OrderItemEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "table")
    private List<OrderEntity> orders;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRoleEntity> userRoles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waiter")
    private List<OrderItemEntity> waiterOrderItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cook")
    private List<OrderItemEntity> cookOrderItems;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public List<OrderItemEntity> getWaiterOrderItems() {
        return waiterOrderItems;
    }

    public List<OrderItemEntity> getCookOrderItems() {
        return cookOrderItems;
    }
}

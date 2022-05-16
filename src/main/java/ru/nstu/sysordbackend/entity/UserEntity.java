package ru.nstu.sysordbackend.entity;

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
}

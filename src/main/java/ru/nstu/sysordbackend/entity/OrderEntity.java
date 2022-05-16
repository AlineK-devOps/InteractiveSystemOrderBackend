package ru.nstu.sysordbackend.entity;

import ru.nstu.sysordbackend.model.OrderModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private UserEntity table;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItemEntity> orderItems;

    public static OrderEntity toEntity(UserEntity tableEntity, List<OrderItemEntity> items){
        OrderEntity entity = new OrderEntity();

        entity.setTable(tableEntity);
        entity.setOrderItems(items);

        return entity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTable(UserEntity table) {
        this.table = table;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public UserEntity getTable() {
        return table;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }
}

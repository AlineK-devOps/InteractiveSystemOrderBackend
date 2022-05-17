package ru.nstu.sysordbackend.entity.order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "statuses")
public class OrderItemStatusEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<OrderItemEntity> orderItems;

    public OrderItemStatusEntity() {
    }

    public OrderItemStatusEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

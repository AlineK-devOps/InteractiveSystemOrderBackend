package ru.nstu.sysordbackend.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {

    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}

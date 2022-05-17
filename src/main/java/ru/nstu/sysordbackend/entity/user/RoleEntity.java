package ru.nstu.sysordbackend.entity.user;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<UserRoleEntity> usersRoles;
}

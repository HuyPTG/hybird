package com.training.hyrid.entities;

import com.training.hyrid.common.ERole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private Integer departmentId;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<UserProfile> listUserProfile = new HashSet<>();

    @Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String name;

    @Column(name = "description", nullable = true, columnDefinition = "NVARCHAR(255)")
    private String description;



}

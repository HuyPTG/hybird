package com.training.hyrid.entities;

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
@Table(name = "branchs")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private Integer branchId;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private Set<UserProfile> listUserProfile = new HashSet<>();

    @Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String name;

    @Column(name = "description", nullable = true, columnDefinition = "NVARCHAR(255)")
    private String description;
}

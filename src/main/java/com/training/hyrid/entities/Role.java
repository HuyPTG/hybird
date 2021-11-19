package com.training.hyrid.entities;

import com.training.hyrid.common.ERole;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)")
	private Integer roleId;

	@Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(255)")
	@Enumerated(EnumType.STRING)
	private ERole name;

	@Column(name = "description", nullable = true, columnDefinition = "NVARCHAR(255)")
	private String description;

	@Column(name = "created_at", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	@Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updateAt;

	public Role() {

	}

	public Role(Integer roleId, ERole name, String description) {
		this.roleId = roleId;
		this.name = name;
		this.description = description;
	}
}

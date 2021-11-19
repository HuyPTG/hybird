package com.training.hyrid.entities;


import com.training.hyrid.dto.PositionDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "positions")
public class Position implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)")
	private Integer PositionId;

	@OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
	private Set<UserProfile> listUserProfile = new HashSet<>();

	@Column(name = "position_name",  nullable = false, columnDefinition = "VARCHAR(255)")
	private String name;

	@Column(name = "description", nullable = true, columnDefinition = "VARCHAR(255)")
	private String description;


}

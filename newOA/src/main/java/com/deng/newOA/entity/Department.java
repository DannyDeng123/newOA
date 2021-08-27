package com.deng.newOA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue
	@Column(name = "dep_id")
	private Long depId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
}

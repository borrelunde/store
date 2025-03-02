package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories", schema = "store")
public class Category {
	@Id
	@Column(name = "id", nullable = false)
	private Byte id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "category")
	private Set<com.borrelunde.store.entities.Product> products = new LinkedHashSet<>();

}
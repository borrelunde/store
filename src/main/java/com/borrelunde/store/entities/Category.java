package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Byte id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category")
	@ToString.Exclude
	@Builder.Default
	private Set<Product> products = new HashSet<>();

	public Category(final byte id) {
		this.id = id;
	}
}
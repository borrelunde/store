package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "tags")
	@ToString.Exclude
	private Set<User> users = new HashSet<>();

	public Tag(final String name) {
		this.name = name;
	}
}

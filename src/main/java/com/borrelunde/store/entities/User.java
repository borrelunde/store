package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

}

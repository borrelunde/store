package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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

	@OneToMany(mappedBy = "user")
	@Builder.Default
	private List<Address> addresses = new ArrayList<>();

	public void addAddress(final Address address) {
		this.addresses.add(address);
		address.setUser(this);
	}

	public void removeAddress(final Address address) {
		this.addresses.remove(address);
		address.setUser(null);
	}
}

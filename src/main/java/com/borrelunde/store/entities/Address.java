package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "zip")
	private String zip;

	@Column(name = "state")
	private String state;
}

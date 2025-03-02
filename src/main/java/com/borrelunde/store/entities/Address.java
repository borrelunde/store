package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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

	@ManyToOne
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
}

package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	private Category category;
}

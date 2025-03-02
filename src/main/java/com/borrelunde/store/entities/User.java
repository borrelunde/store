package com.borrelunde.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
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

	@ManyToMany
	@JoinTable(
			name = "user_tags",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	@Builder.Default
	private Set<Tag> tags = new HashSet<>();

	public void addTag(final String tagName) {
		final Tag tag = new Tag(tagName);
		this.tags.add(tag);
		tag.getUsers().add(this);
	}

	public void removeTag(final Tag tag) {
		this.tags.remove(tag);
		tag.getUsers().remove(this);
	}

	@OneToOne(mappedBy = "user")
	private Profile profile;

	public void addProfile(final Profile profile) {
		this.profile = profile;
		profile.setUser(this);
	}

	public void removeProfile(final Profile profile) {
		this.profile = null;
		profile.setUser(null);
	}

	@ManyToMany
	@JoinTable(
			name = "wishlist",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	@Builder.Default
	private List<Product> wishlist = new ArrayList<>();
}

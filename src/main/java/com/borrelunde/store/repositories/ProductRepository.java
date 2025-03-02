package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
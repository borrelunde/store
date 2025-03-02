package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
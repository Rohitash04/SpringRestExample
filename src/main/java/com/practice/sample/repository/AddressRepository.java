package com.practice.sample.repository;

import com.practice.sample.model.Address;
import com.practice.sample.model.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
    List<AddressEntity> findByZipCode(String zipCode);
}

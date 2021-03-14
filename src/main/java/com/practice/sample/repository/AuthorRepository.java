package com.practice.sample.repository;

import com.practice.sample.model.Author;
import com.practice.sample.model.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    List<AuthorEntity> findByName(String name);
}

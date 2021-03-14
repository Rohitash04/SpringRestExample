package com.practice.sample.repository;

import com.practice.sample.model.Book;
import com.practice.sample.model.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findByName(String name);
}

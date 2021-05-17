package com.practice.sample.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.practice.sample.model.Book;
import com.practice.sample.model.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;

// from https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html section 2.4 

public class BookRepositorySpecification implements Specification<BookEntity> {

  private Book book;

  public BookRepositorySpecification(Book book) {
    this.book = book;
  }

  @Override
  public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> cq, CriteriaBuilder builder) {
    List<Predicate> predicates = new ArrayList<>();

  
    predicates.add(builder.equal(root.get("id"), book.getId()));

    if (book.getName() != null && !book.getName().isEmpty()) {
      predicates.add(
        builder.equal(root.get("name"), book.getName()));
    }

    predicates.add(builder.notEqual(root.get("authorEntity").get("id"), "Undefined"));

    return builder.and(predicates.toArray(new Predicate[0]));
  }
}

//To Use
//BookRepositorySpecification bookRepositorySpecification = new BookRepositorySpecification(payload);
 //   books = bookRepository.findAll(bookRepositorySpecification);

package com.practice.sample.repository;

import com.practice.sample.model.Publication;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, Long> {
}

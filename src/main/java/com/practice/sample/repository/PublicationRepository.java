package com.practice.sample.repository;

import com.practice.sample.model.Publication;
import com.practice.sample.model.entity.PublicationEntity;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<PublicationEntity, Long> {
    PublicationEntity findByCode(String code);
}

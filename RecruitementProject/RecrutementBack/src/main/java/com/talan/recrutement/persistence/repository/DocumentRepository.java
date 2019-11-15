package com.talan.recrutement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.talan.recrutement.persistence.entity.DocumentEntity;


@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Integer> {

}

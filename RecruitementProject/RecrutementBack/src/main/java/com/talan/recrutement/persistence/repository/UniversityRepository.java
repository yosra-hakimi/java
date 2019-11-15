package com.talan.recrutement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talan.recrutement.persistence.entity.UniversityEntity;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Integer> {

}

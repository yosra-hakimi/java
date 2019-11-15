package com.talan.recrutement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talan.recrutement.persistence.entity.EvaluationEntity;

public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer>{

}

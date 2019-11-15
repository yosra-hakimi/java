package com.talan.recrutement.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.talan.recrutement.persistence.entity.InterviewEntity;;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity, Integer> {

	

}
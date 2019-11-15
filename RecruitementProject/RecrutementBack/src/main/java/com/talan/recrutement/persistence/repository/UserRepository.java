package com.talan.recrutement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.persistence.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


	
}

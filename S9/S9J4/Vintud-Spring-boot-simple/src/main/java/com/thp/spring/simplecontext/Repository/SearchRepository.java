package com.thp.spring.simplecontext.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thp.spring.simplecontext.entity.impl.SearchImpl;

@Repository
public interface SearchRepository extends JpaRepository<SearchImpl, Integer>{

}

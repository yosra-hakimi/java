package com.thp.simplecontext.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.simplecontext.entity.Bateau;



public interface BateauService {

	   int create(int id, String name, String type, double taille);

	   Bateau findById(int id);

	   List< Bateau> findAll();

}

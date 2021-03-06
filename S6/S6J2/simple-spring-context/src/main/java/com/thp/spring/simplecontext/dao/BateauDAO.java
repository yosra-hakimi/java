package com.thp.spring.simplecontext.dao;
import java.util.List;

import com.thp.spring.simplecontext.entity.Bateau;

public interface BateauDAO {

	   int create(int id, String name, String type, double taille);

	   Bateau findById(int id);

	   List< Bateau> findAll();

	}
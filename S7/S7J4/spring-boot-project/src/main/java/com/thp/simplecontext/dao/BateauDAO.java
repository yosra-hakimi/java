package com.thp.simplecontext.dao;
import java.util.List;

import com.thp.simplecontext.entity.Bateau;

public interface BateauDAO {

	   int create(int id, String name, String type, double taille);

	   Bateau findById(int id);

	   List< Bateau> findAll();

	}
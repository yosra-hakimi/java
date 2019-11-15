package com.thp.simplecontext.dao;
import java.util.List;

import com.thp.simplecontext.entity.Moussaillon;


public interface MoussaillonDAO {

	   int create(int id, String firstName, String lastName, String config, int bateau_id);

	   Moussaillon findById(int id);

	   List< Moussaillon> findAll();

	   List< Moussaillon> findAllByBateau(int bateauId);

	  int createMoussaillon(Moussaillon moussaillon) ;
	 
	  int delete(int id) ;
	}
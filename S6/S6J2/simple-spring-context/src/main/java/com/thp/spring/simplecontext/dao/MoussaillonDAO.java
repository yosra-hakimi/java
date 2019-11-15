package com.thp.spring.simplecontext.dao;
import com.thp.spring.simplecontext.entity.Moussaillon;

import java.util.List;


public interface MoussaillonDAO {

	   int create(int id, String firstName, String lastName, String config, int bateau_id);

	   Moussaillon findById(int id);

	   List< Moussaillon> findAll();

	   List< Moussaillon> findAllByBateau(int bateauId);

	}
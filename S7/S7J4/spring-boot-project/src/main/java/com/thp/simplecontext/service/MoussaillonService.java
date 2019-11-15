package com.thp.simplecontext.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.simplecontext.entity.Moussaillon;


public interface MoussaillonService {
	  int create(int id, String firstName, String lastName, String config, int bateau_id);

	   Moussaillon findById(int id);

	   List< Moussaillon> findAll();

	   List< Moussaillon> findAllByBateau(int bateauId);
	   
	   int createMoussaillon(Moussaillon moussaillon) ;
	   
	   public int delete(int id) ;
}

package com.thp.simplecontext.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.simplecontext.dao.MoussaillonDAO;
import com.thp.simplecontext.entity.Moussaillon;
import com.thp.simplecontext.service.MoussaillonService;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class MoussaillonServiceImpl implements MoussaillonService {
	  @Autowired
	    private MoussaillonDAO moussaillondao;
	  
	  
	
	  
	@Override
	public int create(int id, String firstName, String lastName, String config, int bateau_id) {
		return	moussaillondao.create(id, firstName, lastName, config, bateau_id);
		
	}

	@Override
	public Moussaillon findById(int id) {
		
		return moussaillondao.findById(id);
	}

	@Override
	public List<Moussaillon> findAll() {
	
		return moussaillondao.findAll();
	}

	@Override
	public List<Moussaillon> findAllByBateau(int bateauId) {
		
		return moussaillondao.findAllByBateau(bateauId);
	}

	@Override
	public int createMoussaillon(Moussaillon moussaillon) {
		return moussaillondao.createMoussaillon(moussaillon);

	}

	@Override
	public int delete(int id) {
		
		return moussaillondao.delete(id); 
	
	}

}

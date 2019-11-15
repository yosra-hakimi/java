package com.thp.simplecontext.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.simplecontext.dao.BateauDAO;
import com.thp.simplecontext.entity.Bateau;
import com.thp.simplecontext.service.BateauService;


@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class BateauServiceImpl implements BateauService {

	@Autowired
    private BateauDAO bateaudao;
	
	@Override
	public int create(int id, String name, String type, double taille) {
	
		return bateaudao.create(id, name, type, taille);
	}

	@Override
	public Bateau findById(int id) {

		return bateaudao.findById(id);
	}

	@Override
	public List<Bateau> findAll() {
	
		return bateaudao.findAll();
	}

}

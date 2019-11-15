package com.thp.project.vintud.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.entity.impl.FavorisImpl;
import com.thp.project.vintud.service.FavorisService;


@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class FavorisServiceImpl implements FavorisService  {

	@Override
	public void addFavorit(FavorisImpl newfavorit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorit(int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFavorit(int id) {
		// TODO Auto-generated method stub
		
	}

}

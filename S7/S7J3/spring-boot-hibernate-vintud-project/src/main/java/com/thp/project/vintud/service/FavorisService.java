package com.thp.project.vintud.service;

import com.thp.project.vintud.entity.impl.FavorisImpl;

public interface FavorisService {
	public void addFavorit(FavorisImpl newfavorit);

	public void getFavorit(int idUser);

	public void removeFavorit(int id);

}

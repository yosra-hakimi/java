package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.FavorisImpl;

public interface DaoFavoris {

	public void addFavorit(FavorisImpl newfavorit);

	public void getFavorit(int idUser);

	public void removeFavorit(int id);

}

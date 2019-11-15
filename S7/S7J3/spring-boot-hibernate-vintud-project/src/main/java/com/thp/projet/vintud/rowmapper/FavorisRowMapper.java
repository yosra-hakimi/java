package com.thp.projet.vintud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thp.project.vintud.entity.impl.FavorisImpl;




public class FavorisRowMapper implements RowMapper<FavorisImpl>{

	public FavorisImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FavorisImpl Favoris = new FavorisImpl();

		Favoris.setIdUser(rs.getInt("id_user"));
		Favoris.setIdAnnouncement(rs.getInt("id_announcement"));
		Favoris.setDateOfAdd(rs.getDate("dateOfAdd"));
		
		
		return Favoris;
	}

}









package com.thp.projet.vintud.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;



public class AnnouncementRowMapper implements RowMapper<AnnouncementImpl>{

	public AnnouncementImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 AnnouncementImpl announce = new  AnnouncementImpl() ;
		 
		    announce.setId(rs.getInt("id"));
			announce.setTitle(rs.getString("title").trim());
			announce.setDescription(rs.getString("description").trim());
			announce.setCategoryId(rs.getInt("category_id"));
			announce.setPrice(rs.getFloat("price"));
		    announce.setPicture(rs.getInt("picture"));
			announce.setPublicationDate(rs.getString("publication_date"));
			announce.setIsAvailable(rs.getBoolean("is_available"));
			announce.setViewNumber(rs.getInt("view_number"));
			announce.setLocalisation(rs.getString("localisation").trim());
			announce.setUserId(rs.getInt("user_id"));
		
		return announce;
	}

}


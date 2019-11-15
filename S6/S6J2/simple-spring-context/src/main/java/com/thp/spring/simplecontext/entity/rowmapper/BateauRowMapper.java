package com.thp.spring.simplecontext.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thp.spring.simplecontext.entity.Bateau;


public class BateauRowMapper implements RowMapper<Bateau>{

	
		   public Bateau mapRow(ResultSet rs, int rowNum) throws SQLException {
			      Bateau bateau = new Bateau();
			      bateau.setId(rs.getInt("id"));
			      bateau.setName(rs.getString("name"));
			      bateau.setType(rs.getString("type"));
			      bateau.setTaille(rs.getInt("size"));
			   
			    
			      return bateau;
		

	}

		
	
	
	
}

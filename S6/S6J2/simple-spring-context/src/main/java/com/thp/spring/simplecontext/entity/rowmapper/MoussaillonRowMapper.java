package com.thp.spring.simplecontext.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thp.spring.simplecontext.entity.Bateau;
import com.thp.spring.simplecontext.entity.Moussaillon;

public class MoussaillonRowMapper implements RowMapper<Moussaillon> {
	
	   public Moussaillon mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Moussaillon moussaillon = new Moussaillon();
		      moussaillon.setId(rs.getInt("id"));
		      moussaillon.setFirstName(rs.getString("first_name"));	    
		      moussaillon.setLastName(rs.getString("last_name"));
		      moussaillon.setConfig(rs.getString("config"));
		      Bateau bateau = new Bateau(50,"bat","bat",2);
		      moussaillon.setBateau(bateau);
		   
		      return moussaillon;
	

}


	}
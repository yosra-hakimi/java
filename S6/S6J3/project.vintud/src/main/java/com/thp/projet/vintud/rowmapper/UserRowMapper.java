package com.thp.projet.vintud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thp.project.vintud.entity.impl.UserImpl;

public class UserRowMapper implements RowMapper<UserImpl>{

	public UserImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
		  
			   UserImpl user = new UserImpl();
			
			 	user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname").trim());
				user.setName(rs.getString("name").trim());
				user.setPseudo(rs.getString("pseudo").trim());
				user.setMail(rs.getString("mail").trim());
				user.setPhone(rs.getString("phone").trim());
				user.setAddress(rs.getString("address").trim());
				user.setuPassword(rs.getString("u_password").trim());
				user.setroleId(rs.getInt("role_id"));
	 
			      return user;
		
			
		
		
	}

}

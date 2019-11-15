package com.thp.projet.vintud.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thp.project.vintud.entity.impl.SearchImpl;


public class SearchRowMapper implements RowMapper<SearchImpl>{

	public SearchImpl mapRow(ResultSet rs, int rowNum) throws SQLException {

		SearchImpl search = new SearchImpl();
				
			
			  
					search.setId(rs.getInt("id"));
					search.setClothType(rs.getString("cloth_type"));
					search.setColor(rs.getString("color"));
					search.setSize(rs.getString("sizee"));
					search.setMaxPrice((rs.getFloat("max_price")));
					search.setMinPrice((rs.getFloat("min_price")));
					search.setSellerId(rs.getInt("seller_id"));
					search.setSellerId(rs.getInt("user_id"));
		
		
		return search;
	}

}



package com.thp.springmvc.dao.impl;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.thp.springmvc.RowMapper.MoussaillonRowMapper;
import com.thp.springmvc.dao.MoussaillonDAO;
import com.thp.springmvc.entity.Moussaillon;

//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MoussaillonDAOImpl implements MoussaillonDAO {
	private JdbcTemplate template ;

	
	
	
	private final String SQL_CREATE_MOUSSAILLON = "INSERT INTO moussaillonJDBC.moussaillon (id, first_name,last_name, config,bateau_id) VALUES (?,?,?,?,?)";
	
	
	private final String SQL_FIND_MOUSSAILLON_BY_ID = "SELECT * FROM moussaillonJDBC.moussaillon WHERE id=? ";
	
	private final String SQL_FIND_ALL_MOUSSAILLON = "SELECT * FROM moussaillonJDBC.moussaillon";
	
	  public JdbcTemplate getTemplate() {
		return template;
	}
	  
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}
		 
		
	public int create(int id, String firstName, String lastName, String config, int bateau_id) {
		
		 return template.update(SQL_CREATE_MOUSSAILLON, id,firstName, lastName,config, bateau_id);
		
	
	}
	

	
	
	public Moussaillon findById(int id) {
		 return template.queryForObject(SQL_FIND_MOUSSAILLON_BY_ID, new Object[]{id}, new MoussaillonRowMapper() );
	
	}
  


	public List<Moussaillon> findAll() {
		 return (List<Moussaillon>) template.query(SQL_FIND_ALL_MOUSSAILLON,new MoussaillonRowMapper() );

	
	}

	public List<Moussaillon> findAllByBateau(int bateauId) {
		// TODO Auto-generated method stub
		return null;
	}

}

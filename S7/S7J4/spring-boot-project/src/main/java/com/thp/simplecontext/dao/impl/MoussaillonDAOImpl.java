package com.thp.simplecontext.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.simplecontext.RowMapper.MoussaillonRowMapper;
import com.thp.simplecontext.dao.MoussaillonDAO;
import com.thp.simplecontext.entity.Moussaillon;
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class MoussaillonDAOImpl implements MoussaillonDAO {
	@Autowired 
	private JdbcTemplate template ;

	@Autowired
	  private EntityManager  entityManager;
	
	private final String SQL_DELETE_MOUSSAILLON = "DELETE FROM moussaillonJDBC.moussaillon WHERE id = ?";
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
	
	  public int createMoussaillon(Moussaillon moussaillon) {
		  
		  
			return template.update(SQL_CREATE_MOUSSAILLON,moussaillon.getBateau_id(),moussaillon.getFirstName() , moussaillon.getLastName(), moussaillon.getConfig(),moussaillon.getBateau_id());
			  
		  }

	/*
	
	public Moussaillon findById(int id) {
		 return template.queryForObject(SQL_FIND_MOUSSAILLON_BY_ID, new Object[]{id}, new MoussaillonRowMapper() );
	
	}
  */
	public Moussaillon findById(int id) {
	    //Avant : jdbcTemplate.queryForObject(SQL_FIND_MOUSSAILLON, new MoussaillonRowMapper(), id);
	    return 	entityManager.createNamedQuery(Moussaillon.QN.FIND_MOUSSAILLON_BY_ID, Moussaillon.class).setParameter("id", id).getSingleResult(); //Après

	}
	    

	public List<Moussaillon> findAll() {
		// return (List<Moussaillon>) template.query(SQL_FIND_ALL_MOUSSAILLON,new MoussaillonRowMapper() );
   
	        return     entityManager.createNamedQuery(Moussaillon.QN.FIND_ALL_MOUSSAILLON, Moussaillon.class).getResultList();
	
	}

	public List<Moussaillon> findAllByBateau(int bateauId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
	
		return template.update(SQL_DELETE_MOUSSAILLON, id);
	}

}

package com.thp.project.vintud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.dao.DaoUser;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.projet.vintud.rowmapper.UserRowMapper;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class DaoUserImpl implements DaoUser {
	@Autowired
	private JdbcTemplate template ;
	@Autowired
	  private EntityManager  entityManager;
	 private NamedParameterJdbcTemplate namedJdbcTemplate; 

	 public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
	        return namedJdbcTemplate;
	    }

	    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
	        this.namedJdbcTemplate = namedJdbcTemplate;
	    }
	    
	  public JdbcTemplate getTemplate() {
		return template;
	}
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}
		

	private static final String SQL_GET_USER_BY_MAIL =  "SELECT * FROM public.userr WHERE mail = ?";
	
    //private static final String SQL_UPDATE_USER_INFORMATIONS=   "UPDATE public.userr set " + informationType + "= ? " + " where mail=?;";
	
	private static final String SQL_CREATE_ANNOUNCEMENT =  "INSERT INTO public.userr (firstname, name, pseudo, mail, u_password, phone, address, role_id) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	

	

	public UserImpl getUserByMail(String mail) {
		
		//String SQL = SQL_GET_USER_BY_MAIL; 
		//return template.queryForObject(SQL, new Object[] { email }, new UserRowMapper());
		return 	entityManager.createNamedQuery(UserImpl.QN.FIND_USER_BY_MAIL, UserImpl.class).setParameter("mail", mail).getSingleResult();


		
	}

	public void updateUserInformations(String mail, String informationType, String newinformation) {
	
		//String SQL = SQL_UPDATE_USER_INFORMATIONS; //appel � la constante
		//return null;
		
		
		/*

		

		String sql = "UPDATE public.userr set " + informationType + "= ? " + " where mail=?;";

		//try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(2, mail);

			pstmt.setString(1, newinformation);

			pstmt.executeUpdate();

			System.out.println("Your " + informationType + " Has Been Updated");

		}

		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

*/
	}
	

	public void createAccount(String firstname,String  name,String pseudo,String mail,String password,String phone,String address,int roleId) {
		String SQL = SQL_CREATE_ANNOUNCEMENT; 
		
	     template.update(SQL, firstname,  name, pseudo, mail,password,phone,address,roleId);

	     System.out.println("Welcome " + firstname + " " + name);
		
		
	}
	
	@Override
	public void createAccount(UserImpl user) {
	 entityManager.persist(user);
	}

	
	






}

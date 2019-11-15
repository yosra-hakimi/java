package com.thp.project.vintud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.thp.project.vintud.dao.DaoUser;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.projet.vintud.rowmapper.UserRowMapper;

public class DaoUserImpl implements DaoUser {
	
	private JdbcTemplate template ;

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
	

	

	public UserImpl getUserByMail(String email) {
		
		String SQL = SQL_GET_USER_BY_MAIL; 
		return template.queryForObject(SQL, new Object[] { email }, new UserRowMapper());


		
	}

	public void updateUserInformations(String mail, String informationType, String newinformation) {
	
		//String SQL = SQL_UPDATE_USER_INFORMATIONS; //appel à la constante
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
		
		
		/*
		String firstname = newuser.getFirstname();
		String name = newuser.getName();
		String pseudo = newuser.getPseudo();
		String mail = newuser.getMail();
		String phone = newuser.getPhone();
		String address = newuser.getAddress();
		int roleId = newuser.getroleId();
		String password = newuser.getuPassword();
		*/
		
	
		
		/*
		String sql = "INSERT INTO public.userr (firstname, name, pseudo, mail, u_password, phone, address, role_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		//try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, firstname);
			pstmt.setString(2, name);
			pstmt.setString(3, pseudo);
			pstmt.setString(4, mail);
			pstmt.setString(5, password);
			pstmt.setString(6, phone);
			pstmt.setString(7, address);
			pstmt.setInt(8, roleId);

			pstmt.executeUpdate();
			System.out.println("Welcome " + firstname + " " + name);
		}

		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	*/

	}





}

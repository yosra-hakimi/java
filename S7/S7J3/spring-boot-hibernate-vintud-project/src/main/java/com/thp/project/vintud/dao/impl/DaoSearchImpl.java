package com.thp.project.vintud.dao.impl;


import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.dao.DaoSearch;
import com.thp.project.vintud.entity.impl.SearchImpl;
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class DaoSearchImpl implements DaoSearch {
	
	private static final String SQL_ADD_ELEMENT = "INSERT INTO public.searchh (cloth_type, sizee, color, min_price, max_price,seller_id) VALUES  ( ?, ?, ?, ?, ?,?,?);";
	
	private static final String SQL_GET_ELEMENT_BY_ID=  "SELECT * FROM public.searchh ";
	
	private static final String SQL_GET_ELEMENT_BY_USERID  = "SELECT * FROM public.searchh where user_id = ?";
	
	//private static final String SQL_UPDATE_ELEMENT  = "UPDATE  public.searchh SET "+caseToUpdate+" = ? where id = ?";
	
	private static final String SQL_DELETE_ELEMENT_BY_ID = "DELETE FROM  public.searchh WHERE id = ?  ";
	
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
		


	public int addElement(SearchImpl element) {
		String SQL =SQL_ADD_ELEMENT; 
		
		 return template.update(SQL , element.getClothType(),element.getSize(), element.getColor(),element.getMinPrice(),element.getMaxPrice(),element.getSellerId(),element.getuserId());
		
		
		/*
		
		int success = 2;

		try {

		//	String sql = "INSERT INTO public.searchh (cloth_type, sizee, color, min_price, max_price,seller_id) VALUES  ( ?, ?, ?, ?, ?,?,?);";
			
			//PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, element.getClothType());
			pstmt.setString(2, element.getSize());
			pstmt.setString(3, element.getColor());
			pstmt.setFloat(4, element.getMinPrice());
			pstmt.setFloat(5, element.getMaxPrice());
			pstmt.setInt(6, element.getSellerId());
			pstmt.setInt(7, element.getuserId());
		

			success = pstmt.executeUpdate();

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		if (success == 1)
			return true;
		return false;
		
		*/
	}

	
	
	public ArrayList<SearchImpl> getElement(int id) {
		String SQL =SQL_GET_ELEMENT_BY_ID; 
		
		return null;
		/*
	
		//String sql = "SELECT * FROM public.searchh ";
		if (id != 0) {
			sql = sql + " where id = ?";
		}

		ArrayList<Search> listsearchs = new ArrayList<>();

	//	try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			if (id != 0) {

				pstmt.setInt(1, id);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Search search = DaoFactory.getSearch();
				search.setId(rs.getInt("id"));
				search.setClothType(rs.getString("cloth_type"));
				search.setColor(rs.getString("color"));
				search.setSize(rs.getString("sizee"));
				search.setMaxPrice((rs.getFloat("max_price")));
				search.setMinPrice((rs.getFloat("min_price")));
				search.setSellerId(rs.getInt("seller_id"));
				search.setSellerId(rs.getInt("user_id"));

				listsearchs.add( search);

			}
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		return listsearchs;
		
		*/
		
	}
	
	public ArrayList<SearchImpl> getElementByUserId(int id) {
		String SQL =SQL_GET_ELEMENT_BY_USERID; 
		return null;
	
		
		/*
		//String sql = "SELECT * FROM public.searchh where user_id = ?";
	

		ArrayList<Search> listsearchs = new ArrayList<>();

		//try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			if (id != 0) {

				pstmt.setInt(1, id);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Search search = DaoFactory.getSearch();
				search.setId(rs.getInt("id"));
				search.setClothType(rs.getString("cloth_type"));
				search.setColor(rs.getString("color"));
				search.setSize(rs.getString("sizee"));
				search.setMaxPrice((rs.getFloat("max_price")));
				search.setMinPrice((rs.getFloat("min_price")));
				search.setSellerId(rs.getInt("seller_id"));
				search.setSellerId(rs.getInt("user_id"));

				listsearchs.add( search);

			}
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		return listsearchs;
		
		*/
		
	}


	public boolean updateElement(int id, String caseToUpdate, Object newValue) {
		
		//String SQL =SQL_UPDATE_ELEMENT; 
		return false;
		
		/*
		int success = 2;
	
		//String sql1 = "UPDATE  public.searchh SET "+caseToUpdate+" = ? where id = ?";


			//try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
				
				if(caseToUpdate=="cloth_type" ||caseToUpdate=="color"||caseToUpdate=="sizee")
				pstmt.setString(1, (String) newValue); 
				else if(caseToUpdate=="min_price"||caseToUpdate=="max_price") pstmt.setFloat(1, (float) newValue);	
					else if(caseToUpdate=="seller_id")pstmt.setInt(1, (int) newValue);	
					else return false;
				pstmt.setInt(2, id);

				success = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (success == 1)
				return true;
			return false;
			
			*/
	}


	public boolean deleteElement(int id) {
		String SQL =SQL_DELETE_ELEMENT_BY_ID; 
		 
		return false;
		
		
		/*
		int success = 2;
	//	String sql = "DELETE FROM  public.searchh WHERE id = ?  ";
	
		try {

			//PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, id);
			success = pstmt.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		if (success == 1)
			return true;
		return false;
	}
	
	*/
	
	

}
}

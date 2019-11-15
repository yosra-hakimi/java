package com.thp.project.vintud.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.thp.project.vintud.dao.DaoFavoris;
import com.thp.project.vintud.entity.impl.FavorisImpl;

public class DaoFavorisImpl implements DaoFavoris {
	
	
	
	private static final String SQL_CREATE_FAVORIT = "INSERT INTO public.favoris (id_user,id_announcement,dateofadd) VALUES  (?,?,?);";
	
	
	private static final String SQL_REMOVE_FAVORIT_BY_ID = "DELETE FROM public.favoris WHERE id = ? ";
	
	private static final String SQL_FIND_ALL_FAVORIT  = "SELECT * FROM public.favoris ";

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

	public void addFavorit(FavorisImpl f) {
		String SQL = SQL_CREATE_FAVORIT ;
		
		/*
		
		
		try {

			//String sql = "INSERT INTO public.favoris (id_user,id_announcement,dateofadd) VALUES  (?,?,?);";

		//	PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, f.getIdUser());
			pstmt.setInt(2, f.getIdAnnouncement());
			pstmt.setDate(3, f.getDateOfAdd());
			pstmt.executeUpdate();

			System.out.println("Favorit added with successfully");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());}
*/
		
	}

	public void removeFavorit(int id) {
		String SQL = SQL_REMOVE_FAVORIT_BY_ID ;
		
		
/*

		//String sql = "DELETE FROM public.favoris WHERE id = ? ";
		int success = 2;
	//	try(PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			 success=pstmt.executeUpdate();
			 if(success==1) {
			 System.out.println("Favorit removed with successfully");
			 }else System.out.println("Favorit removed faled");

			

		} catch (SQLException e) {
			e.printStackTrace();}
*/
	}

	public void getFavorit(int idUser) {
		String SQL = SQL_FIND_ALL_FAVORIT ;
		
/*
		//String sql = "SELECT * FROM public.favoris ";
		if (idUser != 0) {
			sql = sql + " where id_user = ?";
		}

		//ArrayList<Favorit> listFavorit = new ArrayList<>();

		//try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			if (idUser != 0) {

				pstmt.setInt(1, idUser);
			}
			ResultSet rs = pstmt.executeQuery();
			DaoAnnouncement daoAnnouncement = new DaoAnnouncement();

			while (rs.next()) {

				for (AnnouncementImpl announce : daoAnnouncement.getElement(rs.getInt("id_announcement")))
					System.out.println(announce);

			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		} 

	}
	*/

}


}

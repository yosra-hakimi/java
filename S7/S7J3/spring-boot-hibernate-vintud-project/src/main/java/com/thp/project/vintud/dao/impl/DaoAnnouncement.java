package com.thp.project.vintud.dao.impl;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.dao.DaoAnnounce;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.SearchImpl;
import com.thp.projet.vintud.rowmapper.AnnouncementRowMapper;




@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class DaoAnnouncement implements DaoAnnounce {

	private static final String SQL_CREATE_ANNOUNCEMENT = "INSERT INTO public.announcement (title, description, category_id, price, picture,publication_Date,is_available,view_number,localisation,user_id) VALUES  (?,?,?, ?, ?, ?, ?, ?, ?,?);";
	
	
	private static final String SQL_FIND_ANNOUNCEMENT_BYID =  "SELECT * FROM public.announcement where id = ? ";
	
	private final String SQL_FIND_ALL_ANNOUNCEMENTS_BY_USERID 	= "SELECT * FROM public.announcement WHERE userid=?";
	private final String SQL_UPDATE_ANNOUNCEMENT				= "UPDATE public.announcement SET title=? WHERE id=?";



	//private static final String SQL_UPADTE_ANNOUNCEMENT  ="UPDATE  public.announcement ";
	
	private static final String SQL_DELETE_ANNOUNCEMENT_BYID  ="DELETE FROM  public.announcement WHERE id = ?" ;
	
	private static final String SQL_SEARCH_ANNOUNCEMENT = "SELECT * FROM public.announcement WHERE (description LIKE '% %' );";
	private final String SQL_FIND_ANNOUNCEMENTS_BY_TITLE    	= "SELECT * FROM public.announcement WHERE title=?";
	private final String SQL_FIND_ANNOUNCEMENTS_BY_CATEGORY 	= "SELECT * FROM public.announcement WHERE category_id=?";
	private final String SQL_FIND_ANNOUNCEMENTS_BY_PRICE		= "SELECT * FROM public.announcement WHERE price=?";
	private final String SQL_FIND_ANNOUNCEMENTS_ORDERBY_PRICE   = "SELECT * FROM public.announcement ORDER BY price";

	
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
		
	
	
	public int addElement(String title,String description,int category_id,float price,String picture,String publication_Date,boolean is_available,int view_number,String localisation,int user_id) {
		String SQL = SQL_CREATE_ANNOUNCEMENT ;
		
	    return template.update(SQL, title, description, category_id, price, picture, publication_Date, is_available, view_number, localisation, user_id);

		
		
		
	/*
		int success = 2;

		try {

			String sql = 

			//PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, e.getTitle());
			pstmt.setString(2, e.getDescription());
			pstmt.setInt(3, e.getCategoryId());
			pstmt.setFloat(4, e.getPrice());
			pstmt.setString(5, "photo");
			pstmt.setDate(6, (java.sql.Date) e.getPublicationDate());
			pstmt.setBoolean(7, true);
			pstmt.setInt(8, e.getViewNumber());
			pstmt.setString(9, e.getLocalisation());
			pstmt.setInt(10, 1);

			//success = pstmt.executeUpdate();

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		if (success == 1)
			return true;
		return false;
		
		*/
		

	}
	
	
	


	public AnnouncementImpl getElement(int id) {
		//String SQL = SQL_FIND_ANNOUNCEMENT_BYID ;
		//return template.queryForObject(SQL, new Object[]{id}, new AnnouncementRowMapper());
		 return 	entityManager.createNamedQuery(AnnouncementImpl.QN.FIND_Announcement_BY_ID, AnnouncementImpl.class).setParameter("id", id).getSingleResult();

	
	
	}
	
	
	public int updateAnnouncement(String title, long id) {
		String SQL = SQL_UPDATE_ANNOUNCEMENT;
		return template.update(SQL, title, id);
	}

	
	public boolean updateElement(int id, String caseToUpdate, Object newValue) {
		//String SQL = SQL_UPADTE_ANNOUNCEMENT ;
		return false;
		
		
		/*
		int success = 2;
	
		//String sql1 = "UPDATE  public.announcement ";
		String sql2 = "where id = ?";
		switch (caseToUpdate) {
		case "title":
			sql1 += "SET title = ?" + sql2;

			//try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
				pstmt.setString(1, (String) newValue);
				pstmt.setInt(2, id);

				success = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "description":
			sql1 += "SET description = ? " + sql2;

			//try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
				pstmt.setString(1, (String) newValue);
				pstmt.setInt(2, id);

				success = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "price":
			sql1 += "SET price = ? " + sql2;

			//try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
				pstmt.setDouble(1, (Double) newValue);
				pstmt.setInt(2, id);

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "isAvailable":

			sql1 += "SET is_available = ? " + sql2;

			//try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
				pstmt.setBoolean(1, (Boolean) newValue);
				pstmt.setInt(2, id);

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		default:
			break;

		}
		if (success == 1)
			return true;
		return false;
		*/
	}


	public boolean deleteElement(AnnouncementImpl e) {
		String SQL = SQL_DELETE_ANNOUNCEMENT_BYID ;
		return false;
	/*
		int success = 2;
		//String sql = "DELETE FROM  public.announcement WHERE id = ?  ";
		Connection connection = DaoFactory.initConnection();
	//	try {

			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, e.getId());
			success = pstmt.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		if (success == 1)
			return true;
		return false;
		*/
	}
	
	public ArrayList<AnnouncementImpl> SearchAnnouncement(SearchImpl search) {
		String SQL = SQL_SEARCH_ANNOUNCEMENT ;
		return null;
		
		/*
	}
	
	//	String sql = "SELECT * FROM public.announcement WHERE (description LIKE '% %' );";
		if(search.getColor()!="") sql = sql +" AND(description LIKE '%"+search.getColor()+"%' )";
		if(search.getMaxPrice()!=0 ) sql = sql + "AND ( price > "+search.getMinPrice()+" AND price < "+search.getMaxPrice()+" )";
		if(search.getSellerId()!=0) sql = sql + "AND ( id = '"+search.getSellerId()+")";

		ArrayList<AnnouncementImpl> listAnnounces = new ArrayList<>();

		//try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//Announcement announce = DaoFactory.getAnnouncement();
				announce.setId(rs.getInt("id"));
				announce.setTitle(rs.getString("title").trim());
				announce.setDescription(rs.getString("description").trim());
				announce.setPrice(rs.getFloat("price"));
				announce.setPublicationDate(rs.getDate("publication_date"));
				announce.setIsAvailable(rs.getBoolean("is_available"));
				announce.setViewNumber(rs.getInt("view_number"));

				listAnnounces.add((AnnouncementImpl) announce);

			}
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		return listAnnounces;
		*/
	}

	public int deleteAnnouncement(long id) {
		String SQL = SQL_DELETE_ANNOUNCEMENT_BYID ;
		return template.update(SQL, id);
		}
	
	public List<AnnouncementImpl> searchAnnouncementTitle(String title) {
		String SQL = SQL_FIND_ANNOUNCEMENTS_BY_TITLE;
		return template.query(SQL, new Object[]{title}, new AnnouncementRowMapper());
	}
	public List<AnnouncementImpl> searchAnnouncementCategory(int category) {
		String SQL = SQL_FIND_ANNOUNCEMENTS_BY_CATEGORY;
		return template.query(SQL, new Object[]{category}, new AnnouncementRowMapper());
	}
	public List<AnnouncementImpl> searchAnnouncementPrice(Double price) {
		String SQL = SQL_FIND_ANNOUNCEMENTS_BY_PRICE;
		return template.query(SQL, new Object[]{price},  new AnnouncementRowMapper());
	}



	

	
	

}

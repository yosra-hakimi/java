package com.thp.spring.simplecontext.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thp.spring.simplecontext.entity.impl.AnnouncementImpl;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementImpl, Integer>{
	
	@Query("SELECT a FROM AnnouncementImpl a WHERE a.user.id = :id")
	public List<AnnouncementImpl> findByUserId(
	  @Param("id") Integer id);
	
	@Query("SELECT a FROM AnnouncementImpl a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%',:title,'%'))")
	public List<AnnouncementImpl> findByTitle(
	  @Param("title") String title);
	
	@Query("SELECT a FROM AnnouncementImpl a WHERE a.category.categoryName = :category")
	public List<AnnouncementImpl> findByCategory(
	  @Param("category") String category);
	
	@Query("SELECT a FROM AnnouncementImpl a WHERE a.price = :price")
	public List<AnnouncementImpl> findByPrice(
	  @Param("price") Double price);
	
	@Query("SELECT a FROM AnnouncementImpl a ORDER BY a.price")
	public List<AnnouncementImpl> findOrderedByPrice();
	
	@Query("SELECT a FROM AnnouncementImpl a WHERE a.price BETWEEN :price1 AND :price2")
	public List<AnnouncementImpl> findByPriceBeteween(
	  @Param("price1") Double price1, @Param("price2") Double price2);
	
	@Query("SELECT a FROM AnnouncementImpl a GROUP BY a.location, a.id")
	public List<AnnouncementImpl> findByLocation();
	
	@Query("SELECT COUNT(a.id) FROM AnnouncementImpl a")
	public int countAnnouncements();
}

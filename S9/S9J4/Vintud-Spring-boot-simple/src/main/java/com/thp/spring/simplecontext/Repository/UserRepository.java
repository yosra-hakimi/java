package com.thp.spring.simplecontext.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thp.spring.simplecontext.entity.impl.UserImpl;

@Repository
public interface UserRepository extends JpaRepository<UserImpl, Integer>{
	
	@Query("SELECT u FROM UserImpl u WHERE u.mail = :mail")
	public UserImpl findByMail(
	  @Param("mail") String mail);
	
	@Query("SELECT u FROM UserImpl u WHERE u.phoneNumber = :phone")
	public UserImpl findByPhone(
	  @Param("phone") String phone);

}

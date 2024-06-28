package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,String>{

	@Query("select ll from Login ll where ll.emailid = :emailid and ll.password = :password")
	public Login signIn(@Param("emailid") String emailid, @Param("password") String password);
}

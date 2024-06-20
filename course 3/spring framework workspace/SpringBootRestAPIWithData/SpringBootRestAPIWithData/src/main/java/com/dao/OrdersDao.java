package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer>{

	@Query("select o from Orders o where o.pid= :pid")
	public List<Orders> findOrdersByProductId(@Param("pid") int pid);
}

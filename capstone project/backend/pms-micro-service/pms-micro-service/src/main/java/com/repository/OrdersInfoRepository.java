package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.OrdersInfo;

@Repository
public interface OrdersInfoRepository extends JpaRepository<OrdersInfo, Integer>{

	@Query(value = "select o.oid,o.emailid,o.orderdate,o.totalamount,p.pname from orderinfo o,product p,"
			+ "productorderinfo poi where o.oid=poi.orders_info_oid and poi.products_pid=p.pid",
			nativeQuery = true)
	public Object[] viewAllOrdersInfo();
	
	@Query(value = "select o.oid,o.emailid,o.orderdate,o.totalamount,p.pname from orderinfo o,product p,"
			+ "productorderinfo poi where o.oid=poi.orders_info_oid and poi.products_pid=p.pid "
			+ "and o.emailid=:emailid",nativeQuery = true)
	public Object[] viewOrdersInfoByCustomer(@Param("emailid") String emailid);
}

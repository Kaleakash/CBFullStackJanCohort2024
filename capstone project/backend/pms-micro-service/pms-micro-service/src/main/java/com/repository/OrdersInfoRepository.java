package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.OrdersInfo;

@Repository
public interface OrdersInfoRepository extends JpaRepository<OrdersInfo, Integer>{

}

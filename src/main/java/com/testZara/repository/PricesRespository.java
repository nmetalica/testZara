package com.testZara.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.testZara.model.Price;

public interface PricesRespository extends JpaRepository<Price, Long>{
	
	@Query("select a from Price a where a.startDate <= :appTime and a.endDate >= :appTime")
    List<Price> findApplicablePrices(
      @Param("appTime") LocalDateTime appTime);
	
	@Query("select a from Price a where a.startDate <= :appTime and a.endDate >= :appTime and a.brandId = :brandId and a.productId = :productId order by a.priority desc limit 1")
    Price findApplicablePrice(
      @Param("appTime") LocalDateTime appTime,
      @Param("brandId") int brandId,
      @Param("productId") int productId);

}

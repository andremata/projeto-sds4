package com.andremata.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andremata.dsvendas.dtos.SaleSuccessDto;
import com.andremata.dsvendas.dtos.SaleSumDto;
import com.andremata.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.andremata.dsvendas.dtos.SaleSumDto(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj "
			+ " GROUP BY obj.seller")
	List<SaleSumDto> amountGroupedBySeller();
	
	@Query("SELECT new com.andremata.dsvendas.dtos.SaleSuccessDto(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj "
			+ " GROUP BY obj.seller")
	List<SaleSuccessDto> successGroupedBySeller();
}

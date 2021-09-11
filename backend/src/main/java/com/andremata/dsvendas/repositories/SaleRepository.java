package com.andremata.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andremata.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}

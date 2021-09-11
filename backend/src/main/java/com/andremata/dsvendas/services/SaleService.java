package com.andremata.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andremata.dsvendas.dtos.SaleDto;
import com.andremata.dsvendas.entities.Sale;
import com.andremata.dsvendas.repositories.SaleRepository;
import com.andremata.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDto> findAll(Pageable pageable) {
		sellerRepository.findAll(); //armazena os vendedores na memória para não fazer várias consultas no banco de dados para cada vendedor
		
		Page<Sale> result = repository.findAll(pageable); 
		
		return result.map(x -> new SaleDto(x));
	}
}

package com.andremata.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andremata.dsvendas.dtos.SellerDto;
import com.andremata.dsvendas.entities.Seller;
import com.andremata.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDto> findAll() {
		List<Seller> result = repository.findAll(); 
		
		return result.stream().map(x -> new SellerDto(x)).collect(Collectors.toList());
	}
}

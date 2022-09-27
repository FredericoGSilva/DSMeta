package com.br.dsmeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dsmeta.entities.Sale;
import com.br.dsmeta.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSales (String minDate, String maxDate) {
		return repository.findAll();
	}
	
	
}

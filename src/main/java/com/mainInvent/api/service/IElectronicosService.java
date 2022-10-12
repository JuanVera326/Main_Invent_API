package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.ElectronicosVo;


public interface IElectronicosService {
	
	public Iterable<ElectronicosVo> findAll();
	
	public Page<ElectronicosVo> findAll(Pageable page);
	
	public Optional<ElectronicosVo> findByID(Long id);
	
	public Iterable<ElectronicosVo> findByName(String nombre);
	
	public Iterable<ElectronicosVo> findByNameOfFactoryPart(String numParteFabricante);
	
	public Iterable<ElectronicosVo> findByType(String tipo);
	
	
	public ElectronicosVo save(ElectronicosVo usuario);
	
	public void deleteById(Long id);
}

package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.ElectronicosVo;


public interface IElectronicosService {
	
	public Iterable<ElectronicosVo> findAll();
	
	public Page<ElectronicosVo> findAll(Pageable page);
	
	public Optional<ElectronicosVo> findByID(Long id);
	
	public Optional<ElectronicosVo> encontrarPorNombre(String nombre);
	
	public Iterable<ElectronicosVo> encontrarPorNombreGeneral(String nombre);
	
	public Iterable<ElectronicosVo> encontrarPorNumParteFabricante(String numParteFabricante);
	
	public Iterable<ElectronicosVo> encontrarPorTipo(String tipo);
	
	
	public ElectronicosVo save(ElectronicosVo itemelectronico);
	
	public void deleteById(Long id);
}

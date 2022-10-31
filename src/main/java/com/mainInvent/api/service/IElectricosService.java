package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.ElectricosVo;


public interface IElectricosService {
	
	public Iterable<ElectricosVo> findAll();
	
	public Page<ElectricosVo> findAll(Pageable page);
	
	public Optional<ElectricosVo> findByID(Long id);
	
	public Optional<ElectricosVo> encontrarPorNombreItem(String nombre);
	
	public Iterable<ElectricosVo> encontrarPorTipo(String tipo);
	
	public Iterable<ElectricosVo> encontrarPorNombreGeneral(String nombre);
	
	public Iterable<String> obtenerTipos();
	
	public Iterable<ElectricosVo> encontrarPorIdGeneral(Long id);
	
	
	public ElectricosVo save(ElectricosVo itemelectricos);
	
	public void deleteById(Long id);
}

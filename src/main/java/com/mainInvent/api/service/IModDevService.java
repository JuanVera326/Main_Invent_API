package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.ModDevVo;


public interface IModDevService {
	
	public Iterable<ModDevVo> findAll();
	
	public Page<ModDevVo> findAll(Pageable page);
	
	public Optional<ModDevVo> findByID(Long id);
	
	public Optional<ModDevVo> encontrarPorNombre(String nombre);
	
	public Iterable<ModDevVo> encontrarPorTipo(String tipo);
	
	public Iterable<ModDevVo> encontarPorNombreGeneral(String name);
	
	
	public ModDevVo save(ModDevVo itemmoddev);
	
	public void deleteById(Long id);
}

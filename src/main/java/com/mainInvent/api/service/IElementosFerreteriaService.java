package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.ElementosFerrerteriaVo;


public interface IElementosFerreteriaService {
	
	public Iterable<ElementosFerrerteriaVo> findAll();
	
	public Page<ElementosFerrerteriaVo> findAll(Pageable page);
	
	public Optional<ElementosFerrerteriaVo> findByID(Long id);
	
	public Iterable<ElementosFerrerteriaVo> findByName(String nombre);
	
	public Iterable<ElementosFerrerteriaVo> findByType(String tipo);
	
	
	public ElementosFerrerteriaVo save(ElementosFerrerteriaVo usuario);
	
	public void deleteById(Long id);
}

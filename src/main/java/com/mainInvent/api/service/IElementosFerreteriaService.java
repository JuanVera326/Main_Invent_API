package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.ElementosFerrerteriaVo;


public interface IElementosFerreteriaService {
	
	public Iterable<ElementosFerrerteriaVo> findAll();
	
	public Page<ElementosFerrerteriaVo> findAll(Pageable page);
	
	public Optional<ElementosFerrerteriaVo> findByID(Long id);
	
	public Optional<ElementosFerrerteriaVo> encontrarPorNombreItem(String nombre);
	
	public Iterable<ElementosFerrerteriaVo> encontrarPorTipo(String tipo);
	
	public Iterable<ElementosFerrerteriaVo> encontrarPorNombreGeneral(String name);
	
	
	public ElementosFerrerteriaVo save(ElementosFerrerteriaVo usuario);
	
	public void deleteById(Long id);
}

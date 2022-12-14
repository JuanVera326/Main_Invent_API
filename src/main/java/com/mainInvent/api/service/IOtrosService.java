package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.OtrosVo;


public interface IOtrosService {
	
	public Iterable<OtrosVo> findAll();
	
	public Page<OtrosVo> findAll(Pageable page);
	
	public Optional<OtrosVo> findByID(Long id);
	
	public Iterable<OtrosVo> encontrarPorTipo(String tipo);
	
	public Optional<OtrosVo> encontrarPornombre(String nombre);
	
	public Iterable<OtrosVo> encontrarPorNombreGeneral(String nombre);
	
	public Iterable<String> obtenerTipos();
	
	public Iterable<OtrosVo> encontrarPorIdGeneral(Long id);
	
	public OtrosVo save(OtrosVo otro_item);
	
	public void deleteById(Long id);
}

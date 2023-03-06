package com.mainInvent.api.service;

import java.util.Optional;

import com.mainInvent.api.entity.UbicacionVo;

public interface IUbicacionService {

	
	public Iterable<UbicacionVo> findAll();
	
	public Optional<UbicacionVo> findByID(Long id);
	
	public UbicacionVo save(UbicacionVo ubicacion);

	public void deleteById(Long id);
}

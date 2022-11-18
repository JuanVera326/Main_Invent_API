package com.mainInvent.api.service;

import java.util.Optional;

import com.mainInvent.api.entity.Documentos_DatasheetsVo;



public interface IDocumentos_DatasheetsService {
	
	public Iterable<Documentos_DatasheetsVo> findAll();
	
	public Optional<Documentos_DatasheetsVo> findByID(Long id);
	
	public Documentos_DatasheetsVo save(Documentos_DatasheetsVo file);

	public void deleteById(Long id);
}

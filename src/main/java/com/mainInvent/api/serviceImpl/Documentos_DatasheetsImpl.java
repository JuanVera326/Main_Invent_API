package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.Documentos_DatasheetsVo;
import com.mainInvent.api.repository.IDocumentos_DatasheetsRepository;
import com.mainInvent.api.service.IDocumentos_DatasheetsService;

@Service
public class Documentos_DatasheetsImpl implements IDocumentos_DatasheetsService{
	
	@Autowired
	private IDocumentos_DatasheetsRepository repoFiles;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Documentos_DatasheetsVo> findAll() {
		return repoFiles.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Documentos_DatasheetsVo> findByID(Long id) {
		return repoFiles.findById(id);
	}

	@Override
	@Transactional
	public Documentos_DatasheetsVo save(Documentos_DatasheetsVo file) {
		return repoFiles.save(file);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repoFiles.deleteById(id);
	}

}

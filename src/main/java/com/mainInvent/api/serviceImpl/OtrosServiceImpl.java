package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.OtrosVo;
import com.mainInvent.api.repository.IOtrosRepository;
import com.mainInvent.api.service.IOtrosService;

@Service
public class OtrosServiceImpl implements IOtrosService{
	
	@Autowired
	private IOtrosRepository repoOtros;

	@Override
	@Transactional(readOnly = true)
	public Iterable<OtrosVo> findAll() {
		return repoOtros.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<OtrosVo> findAll(Pageable page) {
		return repoOtros.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<OtrosVo> findByID(Long id) {
		return repoOtros.findById(id);
	}

	@Override
	@Transactional
	public OtrosVo save(OtrosVo otro_item) {
		return repoOtros.save(otro_item);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repoOtros.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<OtrosVo> encontrarPornombre(String nombre) {
		return repoOtros.findByNombre_parte_otros(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<OtrosVo> encontrarPorTipo(String tipo) {
		return repoOtros.findByTipo_parte_otros(tipo);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<OtrosVo> encontrarPorNombreGeneral(String nombre) {
		return repoOtros.findByNombre_otros_item(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<String> obtenerTipos() {
		return repoOtros.getTipos();
	}

}

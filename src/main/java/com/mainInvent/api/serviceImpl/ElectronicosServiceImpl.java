package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.ElectronicosVo;
import com.mainInvent.api.repository.IElectronicosRepository;
import com.mainInvent.api.service.IElectronicosService;

@Service
public class ElectronicosServiceImpl implements IElectronicosService{

	@Autowired
	private IElectronicosRepository electronicorepo; 
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectronicosVo> findAll() {
		return electronicorepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ElectronicosVo> findAll(Pageable page) {
		return electronicorepo.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ElectronicosVo> findByID(Long id) {
		return electronicorepo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ElectronicosVo> encontrarPorNombre(String nombre) {
		return electronicorepo.findByName(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectronicosVo> encontrarPorNumParteFabricante(String numParteFabricante) {
		return electronicorepo.findByNumero_partefabricante_comp(numParteFabricante);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectronicosVo> encontrarPorTipo(String tipo) {
		return electronicorepo.findByTipo_comp(tipo);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		electronicorepo.deleteById(id);
	}

	@Override
	@Transactional
	public ElectronicosVo save(ElectronicosVo itemelectronico) {
		return electronicorepo.save(itemelectronico);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectronicosVo> encontrarPorNombreGeneral(String nombre) {
		return electronicorepo.findByNombre_electronicos_item(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<String> obtenerTipos() {
		return electronicorepo.getTipos();
	}
	
}

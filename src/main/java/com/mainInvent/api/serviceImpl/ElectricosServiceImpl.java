package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.ElectricosVo;
import com.mainInvent.api.repository.IElectricosRepository;
import com.mainInvent.api.service.IElectricosService;

@Service
public class ElectricosServiceImpl implements IElectricosService{

	@Autowired
	private IElectricosRepository electricosRepo;

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectricosVo> findAll() {
		return electricosRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ElectricosVo> findAll(Pageable page) {
		return electricosRepo.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ElectricosVo> findByID(Long id) {
		return electricosRepo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ElectricosVo> encontrarPorNombreItem(String nombre) {
		return electricosRepo.findByName(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectricosVo> encontrarPorTipo(String tipo) {
		return electricosRepo.findByTipo_electricos_item(tipo);
	}

	@Override
	@Transactional
	public ElectricosVo save(ElectricosVo itemelectricos) {
		return electricosRepo.save(itemelectricos);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		electricosRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElectricosVo> encontrarPorNombreGeneral(String nombre) {
		return electricosRepo.findByNombre_electricos_item(nombre);
	}
	
	
}

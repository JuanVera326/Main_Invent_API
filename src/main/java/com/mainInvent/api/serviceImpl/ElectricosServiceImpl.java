package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mainInvent.api.entity.ElectricosVo;
import com.mainInvent.api.repository.IElectricosRepository;
import com.mainInvent.api.service.IElectricosService;

@Service
public class ElectricosServiceImpl implements IElectricosService{

	@Autowired
	private IElectricosRepository electricosRepo;

	@Override
	public Iterable<ElectricosVo> findAll() {
		return electricosRepo.findAll();
	}

	@Override
	public Page<ElectricosVo> findAll(Pageable page) {
		return electricosRepo.findAll(page);
	}

	@Override
	public Optional<ElectricosVo> findByID(Long id) {
		return electricosRepo.findById(id);
	}

	@Override
	public Iterable<ElectricosVo> encontrarPorNombre(String nombre) {
		return electricosRepo.findByNombre_electricos_item(nombre);
	}

	@Override
	public Iterable<ElectricosVo> encontrarPorTipo(String tipo) {
		return electricosRepo.findByTipo_electricos_item(tipo);
	}

	@Override
	public ElectricosVo save(ElectricosVo itemelectricos) {
		return electricosRepo.save(itemelectricos);
	}

	@Override
	public void deleteById(Long id) {
		electricosRepo.deleteById(id);
	}
	
	
}

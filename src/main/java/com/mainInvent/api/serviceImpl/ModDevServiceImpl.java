package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.ModDevVo;
import com.mainInvent.api.repository.IModDevRepository;
import com.mainInvent.api.service.IModDevService;

@Service
public class ModDevServiceImpl implements IModDevService{
	
	@Autowired
	private IModDevRepository modDevRepo;

	@Override
	@Transactional(readOnly = true)
	public Iterable<ModDevVo> findAll() {
		return modDevRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ModDevVo> findAll(Pageable page) {
		return modDevRepo.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ModDevVo> findByID(Long id) {
		return modDevRepo.findById(id);
	}

	@Override
	public ModDevVo save(ModDevVo moddev_item) {
		return modDevRepo.save(moddev_item);
	}

	@Override
	public void deleteById(Long id) {
	   modDevRepo.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ModDevVo> encontrarPorNombre(String nombre) {
		return modDevRepo.findByNombre_partemoddev(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ModDevVo> encontrarPorTipo(String tipo) {
		return modDevRepo.findByTipo_parte_moddev(tipo);
	}

}

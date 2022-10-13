package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.ElementosFerrerteriaVo;
import com.mainInvent.api.repository.IElementosFerreteriaRepository;
import com.mainInvent.api.service.IElementosFerreteriaService;


@Service
public class ElementosFerreteriaServiceImpl implements IElementosFerreteriaService {

	@Autowired
	private IElementosFerreteriaRepository eleFerreRepo;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<ElementosFerrerteriaVo> findAll() {
		return eleFerreRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ElementosFerrerteriaVo> findAll(Pageable page) {
		return eleFerreRepo.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ElementosFerrerteriaVo> findByID(Long id) {
		return eleFerreRepo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ElementosFerrerteriaVo> encontrarPorNombre(String nombre) {
		return eleFerreRepo.findByNombre_parte_elementosferreteria(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ElementosFerrerteriaVo> encontrarPorTipo(String tipo) {
		return eleFerreRepo.findByTipo_parte_elementosferreteria(tipo);
	}

	@Override
	public ElementosFerrerteriaVo save(ElementosFerrerteriaVo eleF_item) {
		return eleFerreRepo.save(eleF_item);
	}

	@Override
	public void deleteById(Long id) {
		eleFerreRepo.deleteById(id);
	}

}

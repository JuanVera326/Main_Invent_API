package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.UbicacionVo;
import com.mainInvent.api.repository.IUbicacionRepository;
import com.mainInvent.api.service.IUbicacionService;

@Service
public class UbicacionImpl implements IUbicacionService{
	
	@Autowired
	private IUbicacionRepository repoUbi;

	@Override
	@Transactional(readOnly = true)
	public Iterable<UbicacionVo> findAll() {
		return repoUbi.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UbicacionVo> findByID(Long id) {
		return repoUbi.findById(id);
	}

	@Override
	public UbicacionVo save(UbicacionVo ubicacion) {
		return repoUbi.save(ubicacion);
	}

	@Override
	public void deleteById(Long id) {
		repoUbi.deleteById(id);
	}

	

}

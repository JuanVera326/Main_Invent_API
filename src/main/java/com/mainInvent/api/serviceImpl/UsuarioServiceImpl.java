package com.mainInvent.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainInvent.api.entity.UsuarioVo;
import com.mainInvent.api.repository.IUsuarioRepository;
import com.mainInvent.api.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository repoUsuario;

	@Override
	@Transactional(readOnly = true)
	public Iterable<UsuarioVo> findAll() {
		return repoUsuario.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<UsuarioVo> findAll(Pageable page) {
		return repoUsuario.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsuarioVo> findByID(Long id) {
		return repoUsuario.findById(id);
	}

	@Override
	@Transactional
	public UsuarioVo save(UsuarioVo usuario) {
		return repoUsuario.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repoUsuario.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<UsuarioVo> encontrarPorNombre(String nombre) {
		return repoUsuario.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<UsuarioVo> encontrarPorCargo(String cargo) {
		return repoUsuario.findByCargo(cargo);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsuarioVo> encontrarPorCorreo(String correo) {
		return repoUsuario.findByCorreo(correo);
	}
	@Override
	@Transactional(readOnly = true)
	public Iterable<UsuarioVo> encontrarPorId(Long id) {
		return repoUsuario.findByGeneralID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsuarioVo> findAdmin(int rol) {
		return repoUsuario.findByRol(rol);
	}

}

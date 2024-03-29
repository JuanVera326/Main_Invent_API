package com.mainInvent.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mainInvent.api.entity.UsuarioVo;

public interface IUsuarioService {
	
	public Iterable<UsuarioVo> findAll();
	
	public Page<UsuarioVo> findAll(Pageable page);
	
	public Optional<UsuarioVo> findByID(Long id);
	
	public Optional<UsuarioVo> encontrarPorCorreo(String correo);
	
	public Iterable<UsuarioVo> encontrarPorNombre(String nombre);
	
	public Iterable<UsuarioVo> encontrarPorCargo(String cargo);
	
	public Iterable<UsuarioVo> encontrarPorId(Long id);
 	
	public UsuarioVo save(UsuarioVo usuario);
	
	public void deleteById(Long id);
	
	public Optional<UsuarioVo> findAdmin(int rol);
}

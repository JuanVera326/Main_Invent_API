package com.mainInvent.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.UsuarioVo;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioVo, Long>{
	
	@Query(nativeQuery = true, value = " SELECT * FROM usuarios WHERE nombre_usuario REGEXP CONCAT('^',?1)")
	public Iterable<UsuarioVo> findByNombre(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT * FROM usuarios WHERE cargo_usuario REGEXP CONCAT('^',?1)")
	public Iterable<UsuarioVo> findByCargo(String parte);
	
	@Query(nativeQuery = false, value = " SELECT u FROM UsuarioVo u WHERE correo = ?1")
	public Optional<UsuarioVo> findByCorreo(String parte);
	
	@Query(nativeQuery = true, value = " SELECT * FROM usuarios WHERE id_usuario REGEXP CONCAT('^',?1)")
	public Iterable<UsuarioVo> findByGeneralID(Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM usuarios WHERE rol = ?1")
	public Optional<UsuarioVo> findByRol(int id);
}

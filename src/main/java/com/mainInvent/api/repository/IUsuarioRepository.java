package com.mainInvent.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.UsuarioVo;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT u FROM UsuarioVo u WHERE nombre = ?1")
	public Iterable<UsuarioVo> findByNombre(String nombre);
	
	@Query(nativeQuery = false, value = " SELECT u FROM UsuarioVo u WHERE cargo = ?1")
	public Iterable<UsuarioVo> findByCargo(String parte);
}

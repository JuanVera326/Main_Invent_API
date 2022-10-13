package com.mainInvent.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mainInvent.api.entity.OtrosVo;

public interface IOtrosRepository extends JpaRepository<OtrosVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT o FROM OtrosVo o WHERE nombre_parte_otros = ?1")
	public Optional<OtrosVo> findByNombre_parte_otros(String nombre);
	
	@Query(nativeQuery = false, value = " SELECT o FROM OtrosVo o WHERE tipo_parte_otros = ?1")
	public Iterable<OtrosVo> findByTipo_parte_otros(String parte);
}

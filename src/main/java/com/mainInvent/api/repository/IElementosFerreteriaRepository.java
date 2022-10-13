package com.mainInvent.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElementosFerrerteriaVo;

@Repository
public interface IElementosFerreteriaRepository extends JpaRepository<ElementosFerrerteriaVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT f FROM ElementosFerrerteriaVo f WHERE nombre_parte_elementosferreteria = ?1")
	public Optional<ElementosFerrerteriaVo> findByNombre_parte_elementosferreteria(String nombre);
	
	@Query(nativeQuery = false, value = " SELECT f FROM ElementosFerrerteriaVo f WHERE tipo_parte_elementosferreteria = ?1")
	public Iterable<ElementosFerrerteriaVo> findByTipo_parte_elementosferreteria(String tipo);
}


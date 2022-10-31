package com.mainInvent.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElementosFerrerteriaVo;

@Repository
public interface IElementosFerreteriaRepository extends JpaRepository<ElementosFerrerteriaVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT f FROM ElementosFerrerteriaVo f WHERE nombre_parte_elementosferreteria = ?1")
	public Optional<ElementosFerrerteriaVo> findByNombre(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT * FROM elementosferreteria_items f WHERE tipo_elementosferreteria_items REGEXP CONCAT('^',?1)")
	public Iterable<ElementosFerrerteriaVo> findByTipo_parte_elementosferreteria(String tipo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM elementosferreteria_items WHERE nombre_elementosferreteria_item LIKE %?1%")
	public Iterable<ElementosFerrerteriaVo> findByNombre_elementosferreteria_item_general(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT tipo_elementosferreteria_items FROM elementosferreteria_items")
	public Iterable<String> getTipos();
	
	@Query(nativeQuery = true, value = "SELECT * from elementosferreteria_items WHERE id_elementosferreteria_item REGEXP CONCAT('^',?1)")
	public Iterable<ElementosFerrerteriaVo> getId_eleferre_items(Long id);
}


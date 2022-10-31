package com.mainInvent.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mainInvent.api.entity.OtrosVo;

public interface IOtrosRepository extends JpaRepository<OtrosVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT o FROM OtrosVo o WHERE nombre_parte_otros = ?1")
	public Optional<OtrosVo> findByNombre_parte_otros(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT * FROM otros_items WHERE tipo_otro_items REGEXP CONCAT('^',?1)")
	public Iterable<OtrosVo> findByTipo_parte_otros(String parte);
	
	@Query(nativeQuery = true, value = "SELECT * FROM otros_items WHERE nombre_otro_item LIKE %?1%")
	public Iterable<OtrosVo> findByNombre_otros_item(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT tipo_otro_items FROM otros_items")
	public Iterable<String> getTipos();
	
	@Query(nativeQuery = true, value = "SELECT * from otros_items WHERE id_otro_items REGEXP CONCAT('^',?1)")
	public Iterable<OtrosVo> getId_otros_items(Long id);
}

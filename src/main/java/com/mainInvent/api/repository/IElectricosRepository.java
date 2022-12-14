package com.mainInvent.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElectricosVo;


@Repository
public interface IElectricosRepository extends JpaRepository<ElectricosVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT e FROM ElectricosVo e WHERE nombre_electricos_item = ?1")
	public Optional<ElectricosVo> findByName(String nombre);
	
	@Query(nativeQuery = true, value = "SELECT * FROM electricos_items WHERE tipo_electricos_item REGEXP CONCAT('^',?1)")
	public Iterable<ElectricosVo> findByTipo_electricos_item(String tipo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM electricos_items WHERE nombre_electricos_item LIKE %?1%")
	public Iterable<ElectricosVo> findByNombre_electricos_item(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT tipo_electricos_item FROM electricos_items")
	public Iterable<String> getTipos();
	
	@Query(nativeQuery = true, value = "SELECT * FROM electricos_items WHERE id_electricos_items REGEXP CONCAT('^',?1)")
	public Iterable<ElectricosVo> getId_electricos_items(Long id);
}

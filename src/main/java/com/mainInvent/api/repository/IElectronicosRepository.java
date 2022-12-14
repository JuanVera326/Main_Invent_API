package com.mainInvent.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElectronicosVo;


@Repository
public interface IElectronicosRepository extends JpaRepository<ElectronicosVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT e FROM ElectronicosVo e WHERE nombre_electronicos_item = ?1")
	public Optional<ElectronicosVo> findByName(String nombre);
	
	@Query(nativeQuery = true, value = "SELECT * FROM electronicos_items WHERE tipo_electronicos_items REGEXP CONCAT('^',?1)")
	public Iterable<ElectronicosVo> findByTipo_comp(String tipo);
	
	@Query(nativeQuery = false, value = "SELECT e FROM ElectronicosVo e WHERE numero_partefabricante_comp = ?1")
	public Iterable<ElectronicosVo> findByNumero_partefabricante_comp(String numParteFabricante);
	
	@Query(nativeQuery = true, value = "SELECT * FROM electronicos_items WHERE nombre_electronicos_item LIKE %?1%")
	public Iterable<ElectronicosVo> findByNombre_electronicos_item(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT tipo_electronicos_items FROM electronicos_items")
	public Iterable<String> getTipos();
	
	@Query(nativeQuery = true, value = "SELECT * from electronicos_items WHERE id_electronicos_items REGEXP CONCAT('^',?1)")
	public Iterable<ElectronicosVo> getId_electronicos_items(Long id);
} 

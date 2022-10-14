package com.mainInvent.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElectricosVo;


@Repository
public interface IElectricosRepository extends JpaRepository<ElectricosVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT m FROM ElectricosVo m WHERE nombre_electricos_item = ?1")
	public Iterable<ElectricosVo> findByNombre_electricos_item(String nombre);
	
	@Query(nativeQuery = false, value = " SELECT m FROM ElectricosVo m WHERE tipo_electricos_item = ?1")
	public Iterable<ElectricosVo> findByTipo_electricos_item(String tipo);
	
}

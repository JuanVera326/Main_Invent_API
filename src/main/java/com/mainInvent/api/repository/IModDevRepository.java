package com.mainInvent.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ModDevVo;

@Repository
public interface IModDevRepository extends JpaRepository<ModDevVo, Long>{
	
	@Query(nativeQuery = false, value = " SELECT m FROM ModDevVo m WHERE nombre_partemoddev = ?1")
	public Optional<ModDevVo> findByNombre_partemoddev(String nombre);
	
	@Query(nativeQuery = false, value = " SELECT m FROM ModDevVo m WHERE tipo_parte_moddev = ?1")
	public Iterable<ModDevVo> findByTipo_parte_moddev(String tipo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM moddev_items WHERE nombre_moddev_item LIKE %?1%")
	public Iterable<ModDevVo> findByNombre_moddev_item(String nombre);
	
	@Query(nativeQuery = true, value = " SELECT tipo_moddev_item FROM moddev_items")
	public Iterable<String> getTipos();
}

package com.mainInvent.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "electricos_items")
public class ElectricosVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_electronicos_items", nullable = false)
	private Long id_parte_electricos;
	
	@Column(name = "imagen_electricos_item", nullable = false , length = 800)
	private String imagen_parte_electricos;
	
	@Column(name = "nombre_electricos_item", nullable = false , length = 800)
	private String nombre_parte_electricos;
	
	@Column(name = "descripcion_electricos_item", nullable = false , length = 250)
	private String descripcion_parte_electricos;
	
	@Column(name = "tipo_electricos_item", nullable = false , length = 40)
	private String tipo_parte_electricos;
	
	@Column(name = "cantidadDisp_electricos_item", nullable = false , length = 800)
	private int cantidad_disponible_electricos;
	
	@Column(name = "cantidadCons_electricos_item", nullable = false , length = 800)
	private int cantidad_consumida_electricos;
	
	@Column(name = "ubicacion_electricos_item", nullable = false , length = 250)
	private String ubicacion_parte_electricos;
	
	@Column(name = "datasheet_electricos_item", nullable = false , length = 800)
	private String datasheet_parte_electricos;
	
	public ElectricosVo() {
		
	}
	
	public ElectricosVo(Long id_parte_electricos, String imagen_parte_electricos, String descripcion_parte_electricos,
			String tipo_parte_electricos, int cantidad_disponible_electricos, int cantidad_consumida_electricos,
			String ubicacion_parte_electricos, String datasheet_parte_electricos, String nombre_parte_electricos) {
		super();
		this.id_parte_electricos = id_parte_electricos;
		this.imagen_parte_electricos = imagen_parte_electricos;
		this.descripcion_parte_electricos = descripcion_parte_electricos;
		this.tipo_parte_electricos = tipo_parte_electricos;
		this.cantidad_disponible_electricos = cantidad_disponible_electricos;
		this.cantidad_consumida_electricos = cantidad_consumida_electricos;
		this.ubicacion_parte_electricos = ubicacion_parte_electricos;
		this.datasheet_parte_electricos = datasheet_parte_electricos;
		this.nombre_parte_electricos = nombre_parte_electricos;
		
	}
	
	public String getNombre_parte_electricos() {
		return nombre_parte_electricos;
	}
	public void setNombre_parte_electricos(String nombre_parte_electricos) {
		this.nombre_parte_electricos = nombre_parte_electricos;
	}
	public Long getId_parte_electricos() {
		return id_parte_electricos;
	}
	public void setId_parte_electricos(Long id_parte_electricos) {
		this.id_parte_electricos = id_parte_electricos;
	}
	public String getImagen_parte_electricos() {
		return imagen_parte_electricos;
	}
	public void setImagen_parte_electricos(String imagen_parte_electricos) {
		this.imagen_parte_electricos = imagen_parte_electricos;
	}
	public String getDescripcion_parte_electricos() {
		return descripcion_parte_electricos;
	}
	public void setDescripcion_parte_electricos(String descripcion_parte_electricos) {
		this.descripcion_parte_electricos = descripcion_parte_electricos;
	}
	public String getTipo_parte_electricos() {
		return tipo_parte_electricos;
	}
	public void setTipo_parte_electricos(String tipo_parte_electricos) {
		this.tipo_parte_electricos = tipo_parte_electricos;
	}
	public int getCantidad_disponible_electricos() {
		return cantidad_disponible_electricos;
	}
	public void setCantidad_disponible_electricos(int cantidad_disponible_electricos) {
		this.cantidad_disponible_electricos = cantidad_disponible_electricos;
	}
	public int getCantidad_consumida_electricos() {
		return cantidad_consumida_electricos;
	}
	public void setCantidad_consumida_electricos(int cantidad_consumida_electricos) {
		this.cantidad_consumida_electricos = cantidad_consumida_electricos;
	}
	public String getUbicacion_parte_electricos() {
		return ubicacion_parte_electricos;
	}
	public void setUbicacion_parte_electricos(String ubicacion_parte_electricos) {
		this.ubicacion_parte_electricos = ubicacion_parte_electricos;
	}
	public String getDatasheet_parte_electricos() {
		return datasheet_parte_electricos;
	}
	public void setDatasheet_parte_electricos(String datasheet_parte_electricos) {
		this.datasheet_parte_electricos = datasheet_parte_electricos;
	}

	
}

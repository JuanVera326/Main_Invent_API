package com.mainInvent.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otros_items")
public class OtrosVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_otro_items", nullable = false)
	private Long id_parte_otros;
	
	@Column(name = "nombre_otro_item", nullable = false , length = 80)
	private String nombre_parte_otros;
	
	@Column(name = "imagen_otro_items", nullable = false , length = 800)
	private String imagen_parte_otros;
	
	@Column(name = "descripcion_otro_items", nullable = false , length = 250)
	private String descripcion_parte_otros;
	
	@Column(name = "tipo_otro_items", nullable = false , length = 40)
	private String tipo_parte_otros;
	
	@Column(name = "cantidadDisp_otro_items", nullable = false , length = 10)
	private int cantidad_disponible_otros;
	
	@Column(name = "cantidadCons_otro_items", nullable = false , length = 10)
	private int cantidad_consumida_otros;
	
	@Column(name = "ubicacion_otro_items", nullable = false , length = 250)
	private String ubicacion_parte_otros;
	
	@Column(name = "datasheet_otro_items", nullable = false , length = 800)
	private String datasheet_parte_otros;
	
	public OtrosVo() {
		
	}
	
	public OtrosVo(Long id_parte_otros, String nombre_parte_otros, String imagen_parte_otros,
			String descripcion_parte_otros, String tipo_parte_otros,int cantidad_disponible_otros,int cantidad_consumida_otros,
			String ubicacion_parte_otros, String datasheet_parte_otros) {
		super();
		this.id_parte_otros = id_parte_otros;
		this.nombre_parte_otros = nombre_parte_otros;
		this.imagen_parte_otros = imagen_parte_otros;
		this.descripcion_parte_otros = descripcion_parte_otros;
		this.tipo_parte_otros = tipo_parte_otros;
		this.cantidad_disponible_otros = cantidad_disponible_otros;
		this.cantidad_consumida_otros = cantidad_consumida_otros;
		this.ubicacion_parte_otros = ubicacion_parte_otros;
		this.datasheet_parte_otros = datasheet_parte_otros;
	}
	
	public Long getId_parte_otros() {
		return id_parte_otros;
	}
	public String getNombre_parte_otros() {
		return nombre_parte_otros;
	}
	public void setNombre_parte_otros(String nombre_parte_otros) {
		this.nombre_parte_otros = nombre_parte_otros;
	}
	public void setId_parte_otros(Long id_parte_otros) {
		this.id_parte_otros = id_parte_otros;
	}
	public String getImagen_parte_otros() {
		return imagen_parte_otros;
	}
	public void setImagen_parte_otros(String imagen_parte_otros) {
		this.imagen_parte_otros = imagen_parte_otros;
	}
	public String getDescripcion_parte_otros() {
		return descripcion_parte_otros;
	}
	public void setDescripcion_parte_otros(String descripcion_parte_otros) {
		this.descripcion_parte_otros = descripcion_parte_otros;
	}
	public String getTipo_parte_otros() {
		return tipo_parte_otros;
	}
	public void setTipo_parte_otros(String tipo_parte_otros) {
		this.tipo_parte_otros = tipo_parte_otros;
	}
	public int getCantidad_disponible_otros() {
		return cantidad_disponible_otros;
	}
	public void setCantidad_disponible_otros(int cantidad_disponible_otros) {
		this.cantidad_disponible_otros = cantidad_disponible_otros;
	}
	public int getCantidad_consumida_otros() {
		return cantidad_consumida_otros;
	}
	public void setCantidad_consumida_otros(int cantidad_consumida_otros) {
		this.cantidad_consumida_otros = cantidad_consumida_otros;
	}
	public String getUbicacion_parte_otros() {
		return ubicacion_parte_otros;
	}
	public void setUbicacion_parte_otros(String ubicacion_parte_otros) {
		this.ubicacion_parte_otros = ubicacion_parte_otros;
	}
	public String getDatasheet_parte_otros() {
		return datasheet_parte_otros;
	}
	public void setDatasheet_parte_otros(String datasheet_parte_otros) {
		this.datasheet_parte_otros = datasheet_parte_otros;
	}
	
	
}

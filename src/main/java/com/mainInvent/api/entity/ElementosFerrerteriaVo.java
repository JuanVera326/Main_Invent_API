package com.mainInvent.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "elementosferreteria_items")
public class ElementosFerrerteriaVo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_elementosferreteria_item")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_parte_elementosferreteria;
	
	@Column(name = "nombre_elementosferreteria_item", nullable = false , length = 80)
	private String nombre_parte_elementosferreteria;
	
	@Column(name = "imagen_elementosferreteria_items", nullable = false , length = 800)
	private String imagen_parte_elementosferreteria;
	
	@Column(name = "descripcion_elementosferreteria_items", nullable = false , length = 250)
	private String descripcion_parte_elementosferreteria;
	
	@Column(name = "tipo_elementosferreteria_items", nullable = false , length = 40)
	private String tipo_parte_elementosferreteria;
	
	@Column(name = "cantidadDisp_elementosferreteria_items", nullable = false , length = 10)
	private int cantidad_disponible_elementosferreteria;
	
	@Column(name = "cantidadCons_elementosferreteria_items", nullable = false , length = 10)
	private int cantidad_consumida_elementosferreteria;
	
	@Column(name = "ubicacion_elementosferreteria_items", nullable = false , length = 250)
	private String ubicacion_parte_elementosferreteria;
	
	@OneToMany
	@Column(name = "datasheet_elementosferreteria_items" , length = 800)
	private List<Documentos_DatasheetsVo> datasheet_parte_elementosferreteria;
	
	public ElementosFerrerteriaVo() {
		
	}
	
	public ElementosFerrerteriaVo(Long id_parte_elementosferreteria, String nombre_parte_elementosferreteria, String imagen_parte_elementosferreteria,
			String descripcion_parte_elementosferreteria, String tipo_parte_elementosferreteria,int cantidad_disponible_elementosferreteria,int cantidad_consumida_elementosferreteria,
			String ubicacion_parte_elementosferreteria, List<Documentos_DatasheetsVo> datasheet_parte_elementosferreteria) {
		super();
		this.id_parte_elementosferreteria = id_parte_elementosferreteria;
		this.nombre_parte_elementosferreteria = nombre_parte_elementosferreteria;
		this.imagen_parte_elementosferreteria = imagen_parte_elementosferreteria;
		this.descripcion_parte_elementosferreteria = descripcion_parte_elementosferreteria;
		this.tipo_parte_elementosferreteria = tipo_parte_elementosferreteria;
		this.cantidad_disponible_elementosferreteria = cantidad_disponible_elementosferreteria;
		this.cantidad_consumida_elementosferreteria = cantidad_consumida_elementosferreteria;
		this.ubicacion_parte_elementosferreteria = ubicacion_parte_elementosferreteria;
		this.datasheet_parte_elementosferreteria = datasheet_parte_elementosferreteria;
	}
	
	public String getNombre_parte_elementosferreteria() {
		return nombre_parte_elementosferreteria;
	}
	public void setNombre_parte_elementosferreteria(String nombre_parte_elementosferreteria) {
		this.nombre_parte_elementosferreteria = nombre_parte_elementosferreteria;
	}
	public Long getId_parte_elementosferreteria() {
		return id_parte_elementosferreteria;
	}
	public void setId_parte_elementosferreteria(Long id_parte_elementosferreteria) {
		this.id_parte_elementosferreteria = id_parte_elementosferreteria;
	}
	public String getImagen_parte_elementosferreteria() {
		return imagen_parte_elementosferreteria;
	}
	public void setImagen_parte_elementosferreteria(String imagen_parte_elementosferreteria) {
		this.imagen_parte_elementosferreteria = imagen_parte_elementosferreteria;
	}
	public String getDescripcion_parte_elementosferreteria() {
		return descripcion_parte_elementosferreteria;
	}
	public void setDescripcion_parte_elementosferreteria(String descripcion_parte_elementosferreteria) {
		this.descripcion_parte_elementosferreteria = descripcion_parte_elementosferreteria;
	}
	public String getTipo_parte_elementosferreteria() {
		return tipo_parte_elementosferreteria;
	}
	public void setTipo_parte_elementosferreteria(String tipo_parte_elementosferreteria) {
		this.tipo_parte_elementosferreteria = tipo_parte_elementosferreteria;
	}
	public int getCantidad_disponible_elementosferreteria() {
		return cantidad_disponible_elementosferreteria;
	}
	public void setCantidad_disponible_elementosferreteria(int cantidad_disponible_elementosferreteria) {
		this.cantidad_disponible_elementosferreteria = cantidad_disponible_elementosferreteria;
	}
	public int getCantidad_consumida_elementosferreteria() {
		return cantidad_consumida_elementosferreteria;
	}
	public void setCantidad_consumida_elementosferreteria(int cantidad_consumida_elementosferreteria) {
		this.cantidad_consumida_elementosferreteria = cantidad_consumida_elementosferreteria;
	}
	public String getUbicacion_parte_elementosferreteria() {
		return ubicacion_parte_elementosferreteria;
	}
	public void setUbicacion_parte_elementosferreteria(String ubicacion_parte_elementosferreteria) {
		this.ubicacion_parte_elementosferreteria = ubicacion_parte_elementosferreteria;
	}
	public List<Documentos_DatasheetsVo> getDatasheet_parte_elementosferreteria() {
		return datasheet_parte_elementosferreteria;
	}
	public void setDatasheet_parte_elementosferreteria(List<Documentos_DatasheetsVo> datasheet_parte_elementosferreteria) {
		this.datasheet_parte_elementosferreteria = datasheet_parte_elementosferreteria;
	}
	
	
}

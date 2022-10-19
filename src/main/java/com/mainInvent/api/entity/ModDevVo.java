package com.mainInvent.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "moddev_items")
public class ModDevVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_moddev_item")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_parte_moddev;
	
	//@Lob
	//@Type(type = "org.hibernate.type.ImageType"), columnDefinition = "LONGBLOB"
	@Column(name = "imagen_moddev_item", nullable = false)
	private String imagen_partemoddev;
	
	@Column(name = "nombre_moddev_item", nullable = false , length = 80)
	private String nombre_partemoddev;
	
	@Column(name = "descripcion_moddev_item", nullable = false , length = 250)
	private String descripcion_parte_moddev;
	
	@Column(name = "tipo_moddev_item", nullable = false , length = 40)
	private String tipo_parte_moddev;
	
	@Column(name = "cantidadDisp_moddev_item", nullable = false , length = 10)
	private int cantidad_disponible_moddev;
	
	@Column(name = "cantidadCons_usuario", nullable = false , length = 10)
	private int cantidad_consumida_moddev;
	
	@Column(name = "ubicacion_moddev_item", nullable = false , length = 250)
	private String ubicacion_parte_moddev;
	
	//@Lob
	//@Type(type = "org.hibernate.type.ImageType"), columnDefinition = "LONGBLOB"
	@Column(name = "datasheet_moddev_item")
	private String datasheet_parte_moddev;
	
	public ModDevVo() {
			
	}
	
	public ModDevVo(Long id_parte_moddev, String nombre_partemoddev, String imagen_partemoddev,
			String descripcion_parte_moddev, String tipo_parte_moddev,int cantidad_disponible_moddev,int cantidad_consumida_moddev,
			String ubicacion_parte_moddev, String datasheet_parte_moddev) {
		super();
		this.id_parte_moddev = id_parte_moddev;
		this.nombre_partemoddev = nombre_partemoddev;
		this.imagen_partemoddev = imagen_partemoddev;
		this.descripcion_parte_moddev = descripcion_parte_moddev;
		this.tipo_parte_moddev = tipo_parte_moddev;
		this.cantidad_disponible_moddev = cantidad_disponible_moddev;
		this.cantidad_consumida_moddev = cantidad_consumida_moddev;
		this.ubicacion_parte_moddev = ubicacion_parte_moddev;
		this.datasheet_parte_moddev = datasheet_parte_moddev;
	}
	
	public String getNombre_partemoddev() {
		return nombre_partemoddev;
	}
	public void setNombre_partemoddev(String nombre_partemoddev) {
		this.nombre_partemoddev = nombre_partemoddev;
	}
	public Long getId_parte_moddev() {
		return id_parte_moddev;
	}
	public void setId_parte_moddev(Long id_parte_moddev) {
		this.id_parte_moddev = id_parte_moddev;
	}
	public String getImagen_partemoddev() {
		return imagen_partemoddev;
	}
	public void setImagen_partemoddev(String imagen_partemoddev) {
		this.imagen_partemoddev = imagen_partemoddev;
	}
	public String getDescripcion_parte_moddev() {
		return descripcion_parte_moddev;
	}
	public void setDescripcion_parte_moddev(String descripcion_parte_moddev) {
		this.descripcion_parte_moddev = descripcion_parte_moddev;
	}
	public String getTipo_parte_moddev() {
		return tipo_parte_moddev;
	}
	public void setTipo_parte_moddev(String tipo_parte_moddev) {
		this.tipo_parte_moddev = tipo_parte_moddev;
	}
	public int getCantidad_disponible_moddev() {
		return cantidad_disponible_moddev;
	}
	public void setCantidad_disponible_moddev(int cantidad_disponible_moddev) {
		this.cantidad_disponible_moddev = cantidad_disponible_moddev;
	}
	public int getCantidad_consumida_moddev() {
		return cantidad_consumida_moddev;
	}
	public void setCantidad_consumida_moddev(int cantidad_consumida_moddev) {
		this.cantidad_consumida_moddev = cantidad_consumida_moddev;
	}
	public String getUbicacion_parte_moddev() {
		return ubicacion_parte_moddev;
	}
	public void setUbicacion_parte_moddev(String ubicacion_parte_moddev) {
		this.ubicacion_parte_moddev = ubicacion_parte_moddev;
	}
	public String getDatasheet_parte_moddev() {
		return datasheet_parte_moddev;
	}
	public void setDatasheet_parte_moddev(String datasheet_parte_moddev) {
		this.datasheet_parte_moddev = datasheet_parte_moddev;
	}
}

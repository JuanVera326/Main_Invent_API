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
@Table(name = "electronicos_items")
public class ElectronicosVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_electronicos_items")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Comp;
	
	@Column(name = "nombre_electronicos_item", nullable = false , length = 80)
	private String nombre_comp;
	
	@Column(name = "numeropartefabricante_electronicos_items", nullable = false)
	private String numero_partefabricante_comp;
	
	@Column(name = "pinout_electronicos_items", nullable = false , length = 800)
	private String pinout_comp;
	
	@Column(name = "esquematico_electronicos_items", nullable = false , length = 800)
	private String esquematico_comp;
	
	@Column(name = "descripcion_electronicos_items", nullable = false , length = 250)
	private String descripcion_comp;
	
	@Column(name = "tipo_electronicos_items", nullable = false , length = 40)
	private String tipo_comp;
	
	@Column(name = "encapsulado_electronicos_items", nullable = false , length = 250)
	private String encampsulado_comp;
	
	@Column(name = "cantidadDisp_electronicos_items", nullable = false , length = 10)
	private int cantidad_disponible_comp;
	
	@Column(name = "cantidadCons_electronicos_items", nullable = false , length = 10)
	private int cantidad_consumida_comp;
	
	@Column(name = "ubicacion_electronicos_items", nullable = false , length = 250)
	private String ubicacion_comp;
	
	@OneToMany
	@Column(name = "datasheet_electronicos_items" , nullable = false , length = 800)
	private List<Documentos_DatasheetsVo> datasheet_comp;
	
	public ElectronicosVo() {
		
	}
	
	public ElectronicosVo(Long id_Comp, String nombre_comp,String numero_partefabricante_comp, String pinout_comp,
			String esquematico_comp, String descripcion_comp, String tipo_comp, String encampsulado_comp,
			int cantidad_disponible_comp,int cantidad_consumida_comp, String ubicacion_comp, List<Documentos_DatasheetsVo> datasheet_comp) {
		super();
		this.id_Comp = id_Comp;
		this.nombre_comp = nombre_comp;
		this.numero_partefabricante_comp = numero_partefabricante_comp;
		this.pinout_comp = pinout_comp;
		this.esquematico_comp = esquematico_comp;
		this.descripcion_comp = descripcion_comp;
		this.tipo_comp = tipo_comp;
		this.encampsulado_comp = encampsulado_comp;
		this.cantidad_disponible_comp = cantidad_disponible_comp;
		this.cantidad_consumida_comp = cantidad_consumida_comp;
		this.ubicacion_comp = ubicacion_comp;
		this.datasheet_comp = datasheet_comp;
		
	}
	
	public String getNombre_comp() {
		return nombre_comp;
	}
	public void setNombre_comp(String nombre_comp) {
		this.nombre_comp = nombre_comp;
	}
	public Long getId_Comp() {
		return id_Comp;
	}
	public void setId_Comp(Long id_Comp) {
		this.id_Comp = id_Comp;
	}
	public String getNumero_partefabricante_comp() {
		return numero_partefabricante_comp;
	}
	public void setNumero_partefabricante_comp(String numero_partefabricante_comp) {
		this.numero_partefabricante_comp = numero_partefabricante_comp;
	}
	public String getPinout_comp() {
		return pinout_comp;
	}
	public void setPinout_comp(String pinout_comp) {
		this.pinout_comp = pinout_comp;
	}
	public String getEsquematico_comp() {
		return esquematico_comp;
	}
	public void setEsquematico_comp(String esquematico_comp) {
		this.esquematico_comp = esquematico_comp;
	}
	public String getDescripcion_comp() {
		return descripcion_comp;
	}
	public void setDescripcion_comp(String descripcion_comp) {
		this.descripcion_comp = descripcion_comp;
	}
	public String getTipo_comp() {
		return tipo_comp;
	}
	public void setTipo_comp(String tipo_comp) {
		this.tipo_comp = tipo_comp;
	}
	public String getEncampsulado_comp() {
		return encampsulado_comp;
	}
	public void setEncampsulado_comp(String encampsulado_comp) {
		this.encampsulado_comp = encampsulado_comp;
	}
	public int getCantidad_disponible_comp() {
		return cantidad_disponible_comp;
	}
	public void setCantidad_disponible_comp(int cantidad_disponible_comp) {
		this.cantidad_disponible_comp = cantidad_disponible_comp;
	}
	public int getCantidad_consumida_comp() {
		return cantidad_consumida_comp;
	}
	public void setCantidad_consumida_comp(int cantidad_consumida_comp) {
		this.cantidad_consumida_comp = cantidad_consumida_comp;
	}
	public String getUbicacion_comp() {
		return ubicacion_comp;
	}
	public void setUbicacion_comp(String ubicacion_comp) {
		this.ubicacion_comp = ubicacion_comp;
	}
	public List<Documentos_DatasheetsVo> getDatasheet_comp() {
		return datasheet_comp;
	}
	public void setDatasheet_comp(List<Documentos_DatasheetsVo> datasheet_comp) {
		this.datasheet_comp = datasheet_comp;
	}
	
	
}


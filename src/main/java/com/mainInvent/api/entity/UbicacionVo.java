package com.mainInvent.api.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ubicacion")
public class UbicacionVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_rel_ubi", nullable = false )
	private Long id_rel_ubi;
	
	@Column(name = "sectors", length = 5)
	private int sectors;
	
	@Column(name = "warehouses", length = 5)
	private int warehouses;
	
	@Column(name = "racks", length = 5)
	private int racks;
	
	
	public UbicacionVo (){
		
	}
	
	public UbicacionVo (Long id_rel_ubi, int sectors, int warehouses, int racks) {
		this.id_rel_ubi = id_rel_ubi;
		this.sectors = sectors;
		this.warehouses = warehouses;
		this.racks = racks;
	}

	public Long getId_rel_ubi() {
		return id_rel_ubi;
	}

	public void setId_rel_ubi(Long id_rel_ubi) {
		this.id_rel_ubi = id_rel_ubi;
	}

	public int getSectors() {
		return sectors;
	}

	public void setSectors(int sectors) {
		this.sectors = sectors;
	}

	public int getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(int warehouses) {
		this.warehouses = warehouses;
	}

	public int getRacks() {
		return racks;
	}

	public void setRacks(int racks) {
		this.racks = racks;
	}
}

package com.mainInvent.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos_datasheets")
public class Documentos_DatasheetsVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_doc")
	private Long id_doc;
	
	@Column(name = "file")
	private byte[] file;
	
 
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}

package com.mainInvent.api.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "documentos_datasheets")
public class Documentos_DatasheetsVo implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id_doc;

	@Lob
	@Column(name = "file", columnDefinition = "MEDIUMBLOB")
	private byte[] file;
	// Tamaño maximo de archivos 16,777,215 bytes / 16,7MB
	
	
	
	public Documentos_DatasheetsVo() { 
		
	}

	public Documentos_DatasheetsVo(String id_doc, byte[] file) {
		super();
		this.id_doc = id_doc;
		this.file = file;
	}

	public String getId_doc() {
		return id_doc;
	}

	public void setId_doc(String id_doc) {
		this.id_doc = id_doc;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "Documentos_DatasheetsVo [id_doc=" + id_doc + ", file=" + Arrays.toString(file) + "]";
	}

}

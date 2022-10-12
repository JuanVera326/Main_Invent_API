package com.mainInvent.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario", nullable = false )
	private Long id;
	
	@Column(name = "nombre_usuario", nullable = false , length = 80)
	private String nombre;
	
	@Column(name = "apellido_usuario", nullable = false , length = 80)
	private String apellido;
	
	@Column(name = "cargo_usuario", nullable = false , length = 45)
	private String cargo;
	
	@Column(name = "edad_usuario", nullable = false , length = 2)
	private String edad;
	
	@Column(name = "rol", nullable = false , length = 1)
	private int rol;
	
	@Column(name = "password", nullable = false , length = 100)
	private String password;
	
	@Column(name = "correo", nullable = false , length = 100)
	private String correo;
	
	@Column(name = "estado")
	private boolean estado;
	
	public UsuarioVo(){
		
	}
	
	public UsuarioVo(String nombre, String apellido, String cargo, String edad, int rol, Long id, String password, String correo, boolean estado){
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.edad = edad;
		this.rol = rol;
		this.id = id;
		this.password = password;
		this.correo = correo;
		this.estado = estado;
	}
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

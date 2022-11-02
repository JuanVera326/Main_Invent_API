package com.mainInvent.api.dto;

public class UsuarioDto {
	
	private Long id; 
	
	private String nombre;
	
	private String apellido;
	
	private String cargo;
	
	private String imagen;
	
	private String edad;
	
	private int rol;
	
	private String correo;
	
	private boolean estado;
	
	
	public UsuarioDto(){
		
	}
	
	public UsuarioDto(String nombre, String apellido, String cargo, String imagen, String edad, int rol, String correo, boolean estado, Long id){
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.imagen = imagen;
		this.edad = edad;
		this.rol = rol;
		this.correo = correo;
		this.estado = estado;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}

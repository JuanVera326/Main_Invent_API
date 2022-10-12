package com.mainInvent.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainInvent.api.entity.UsuarioVo;
import com.mainInvent.api.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> saveNewUsuario(@RequestBody UsuarioVo usuario){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(usuario));
	}
	
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable(value = "id") Long usuario_id){
		
		Optional<UsuarioVo> oUsuario = usuarioService.findByID(usuario_id);
		
		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUsuario);
	}
	
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody UsuarioVo usuario, @PathVariable Long id){
			
		Optional<UsuarioVo> usuarioOpti = usuarioService.findByID(id);
		
		if (!usuarioOpti.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(usuario, usuarioOpti.getClass());
		
		usuarioOpti.get().setNombre(usuario.getNombre());
		usuarioOpti.get().setApellido(usuario.getApellido());
		usuarioOpti.get().setCargo(usuario.getCargo());
		usuarioOpti.get().setCorreo(usuario.getCorreo());
		usuarioOpti.get().setEdad(usuario.getEdad());
		usuarioOpti.get().setRol(usuario.getRol());
		usuarioOpti.get().setEstado(usuario.getEstado());
		usuarioOpti.get().setPassword(usuario.getPassword());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(usuarioOpti.get()));
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
		
		if (!usuarioService.findByID(id).isPresent()) {
			ResponseEntity.notFound().build();
		}
		
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/usuarios")
	public List<UsuarioVo> getAllUsuarios(){
		
		List<UsuarioVo> usuariosList = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
	}
}

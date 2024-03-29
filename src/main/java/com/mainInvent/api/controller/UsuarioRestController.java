package com.mainInvent.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainInvent.api.InitialConstructorService;
import com.mainInvent.api.dto.UsuarioDto;
import com.mainInvent.api.entity.UsuarioVo;
import com.mainInvent.api.service.IUsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class UsuarioRestController {
	
	
	@Autowired
	private IUsuarioService usuarioService;
	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	InitialConstructorService constructorService = new InitialConstructorService();
	
	@PostMapping("/usuarios/{keys}")
	public ResponseEntity<?> saveNewUsuario(@RequestBody UsuarioVo usuario, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<UsuarioVo> user = usuarioService.findByID(usuario.getId());
		
		if (user.isPresent()) {
			String msj = "El usuario ya esta registrado con este id";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		String ps = constructorService.wordEncoder(usuario.getPassword());
		
		UsuarioVo userdata = new UsuarioVo(
				usuario.getNombre(),
				usuario.getApellido(),
				usuario.getCargo(),
				usuario.getImagen(),
				usuario.getEdad(),
				usuario.getRol(),
				usuario.getId(),
				ps,
				usuario.getCorreo(),
				usuario.getEstado(),
				usuario.getId_rel_ubi()
		);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(userdata));
	
	}
	
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable(value = "id") Long usuario_id){
		
		Optional<UsuarioVo> oUsuario = usuarioService.findByID(usuario_id);
		
		if (!oUsuario.isPresent()) {
			String msj = "El usuario con id "+ usuario_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		UsuarioDto user = new UsuarioDto( oUsuario.get().getNombre(),
				oUsuario.get().getApellido(), oUsuario.get().getCargo(), oUsuario.get().getImagen(),
				oUsuario.get().getEdad(), oUsuario.get().getRol(), oUsuario.get().getCorreo(), 
				oUsuario.get().getEstado(),oUsuario.get().getId(),null);
		
		if (oUsuario.get().getRol() == 1 || oUsuario.get().getRol() == 3 ) {
			user.setConfig_ubi(oUsuario.get().getId_rel_ubi());
		}
		
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping("/usuarios/{id}/{keys}")
	public ResponseEntity<?> updateUsuario(@RequestBody UsuarioVo usuario, @PathVariable Long id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
			
		Optional<UsuarioVo> usuarioOpti = usuarioService.findByID(id);
		
		if (!usuarioOpti.isPresent()) {
			String msj = "El usuario con id "+ id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		
		usuarioOpti.get().setNombre(usuario.getNombre());
		usuarioOpti.get().setApellido(usuario.getApellido());
		usuarioOpti.get().setCargo(usuario.getCargo());
		usuarioOpti.get().setCorreo(usuario.getCorreo());
		usuarioOpti.get().setEdad(usuario.getEdad());
		usuarioOpti.get().setImagen(usuario.getImagen());
		usuarioOpti.get().setRol(usuario.getRol());
		usuarioOpti.get().setEstado(usuario.getEstado());
		usuarioOpti.get().setPassword(constructorService.wordEncoder(usuario.getPassword()));
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(usuarioOpti.get()));
	}
	
	
	@DeleteMapping("/usuarios/{id}/{keys}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		if (!usuarioService.findByID(id).isPresent()) {
			String msj = "El usuario con id " + id +" que desea eliminar no ha sido encontrado";
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		usuarioService.deleteById(id);
		
		Optional<UsuarioVo> user = usuarioService.findByID(id);
		
		if (user.isPresent()) {
			
			String msj = "El usuario no se ha podido eliminar";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}else {
			String msj = "Usuario eliminado con exito";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(msj);
		}
	}
	
	
	@GetMapping("/usuarios")
	public List<UsuarioVo> getAllUsuarios(){
		
		List<UsuarioVo> usuariosList = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
	}
	
	@GetMapping("/usuarios/name/{name}")
	public List<UsuarioVo> findByName(@PathVariable String name){
		
		List<UsuarioVo> usuariosList = StreamSupport
				.stream(usuarioService.encontrarPorNombre(name).spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
	}
	
	@GetMapping("/usuarios/cargo/{cargo}")
	public List<UsuarioVo> getUserByCargo(@PathVariable String cargo){
		
		List<UsuarioVo> usuariosList = StreamSupport
				.stream(usuarioService.encontrarPorCargo(cargo).spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
	}
	
	@GetMapping("/usuarios/id/{id}")
	public List<UsuarioVo> getUserByGeneralID(@PathVariable Long id){
		
		List<UsuarioVo> usuariosList = StreamSupport
				.stream(usuarioService.encontrarPorId(id).spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
	}
	
}

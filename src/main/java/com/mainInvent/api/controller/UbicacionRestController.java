package com.mainInvent.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mainInvent.api.entity.UbicacionVo;
import com.mainInvent.api.entity.UsuarioVo;
import com.mainInvent.api.service.IUbicacionService;
import com.mainInvent.api.service.IUsuarioService;

public class UbicacionRestController {
	
	@Autowired
	private IUbicacionService ubiService;
	
	@Autowired
	private IUsuarioService usuService; 
	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
    
	@PostMapping("/ubi/{keys}")
	public ResponseEntity<?> saveUbi(@RequestBody UbicacionVo ubicacion, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<UsuarioVo> user = usuService.findByID(ubicacion.getId_rel_ubi());
		
		if (!user.isPresent()) {
			String msj = "El Usuario de ID " + ubicacion.getId_rel_ubi() + " no Existe";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ubiService.save(ubicacion));
	}
	
	@GetMapping("/ubi/{id}")
	public ResponseEntity<?> getUbi(@PathVariable Long id){
		
		Optional<UbicacionVo> ubi = ubiService.findByID(id);
		
		if (!ubi.isPresent()){
			String msj = "Ubicacion no con Id relacionado no Existe";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ubi.get());
	}
	
	@DeleteMapping("/ubi/{id}/{keys}")
	public ResponseEntity<?> delUbi(@PathVariable Long id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<UbicacionVo> file = ubiService.findByID(id);
		
		if (!file.isPresent()){
			String msj = "Error";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		ubiService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
	}
}

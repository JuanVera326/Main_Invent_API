package com.mainInvent.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.mainInvent.api.entity.ModDevVo;
import com.mainInvent.api.service.IModDevService;

@RestController
@RequestMapping("/api")
public class ModDevRestController {

	@Autowired
	private IModDevService modDevService;
	
	@PostMapping("/moddev")
	public ResponseEntity<?> saveModdev(@RequestBody ModDevVo moddev){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(modDevService.save(moddev));
	}
	
	@GetMapping("/moddev/{id}")
	public ResponseEntity<?> getModdev(@PathVariable(value = "id") Long moddev_id){
		
		Optional<ModDevVo> oModdev = modDevService.findByID(moddev_id);
		
		if (!oModdev.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oModdev);
	} 
	
	@PutMapping("/moddev/{id}")
	public ResponseEntity<?> updateModdev(@RequestBody ModDevVo moddev, @PathVariable(value = "id") Long moddev_id){
		
		Optional<ModDevVo> moddevOpti = modDevService.findByID(moddev_id);
		
		if(!moddevOpti.isPresent()){
			return ResponseEntity.notFound().build();
        }
		
		moddevOpti.get().setNombre_partemoddev(moddev.getNombre_partemoddev());
		moddevOpti.get().setImagen_partemoddev(moddev.getImagen_partemoddev());
		moddevOpti.get().setDescripcion_parte_moddev(moddev.getDescripcion_parte_moddev());
		moddevOpti.get().setTipo_parte_moddev(moddev.getTipo_parte_moddev());
		moddevOpti.get().setCantidad_disponible_moddev(moddev.getCantidad_disponible_moddev());
		moddevOpti.get().setCantidad_consumida_moddev(moddev.getCantidad_consumida_moddev());
		moddevOpti.get().setUbicacion_parte_moddev(moddev.getUbicacion_parte_moddev());
		moddevOpti.get().setDatasheet_parte_moddev(moddev.getDatasheet_parte_moddev());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(modDevService.save(moddevOpti.get()));
		
	}
	
	@DeleteMapping("/moddev/{id}")
	public ResponseEntity<?> deleteModdev(@PathVariable(value = "id") Long id){
		if (!modDevService.findByID(id).isPresent()) {
			ResponseEntity.notFound().build();
		}
		modDevService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/moddev")
	public List<ModDevVo> getAllModdev(){
		
		List<ModDevVo> moddevList = StreamSupport
				.stream(modDevService.findAll().spliterator(), false).collect(Collectors.toList());
		return moddevList;
	}
	
	@GetMapping("/moddev/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
	  return ResponseEntity.ok(modDevService.encontrarPorNombre(name));
	}
	
	@GetMapping("/moddev/type/{tipo}")
	public List<ModDevVo> getByType(@PathVariable String tipo){
		List<ModDevVo> moddevList = StreamSupport
				.stream(modDevService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return moddevList;
	}
}

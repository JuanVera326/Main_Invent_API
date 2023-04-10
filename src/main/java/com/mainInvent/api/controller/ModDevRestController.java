package com.mainInvent.api.controller;

import java.util.ArrayList;
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


import com.mainInvent.api.entity.ModDevVo;
import com.mainInvent.api.service.IModDevService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ModDevRestController {

	@Autowired
	private IModDevService modDevService;
	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	@PostMapping("/moddev/{keys}")
	public ResponseEntity<?> saveModdev(@RequestBody ModDevVo moddev, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<ModDevVo> mod = modDevService.encontrarPorNombre(moddev.getNombre_partemoddev());
		
		if (mod.isPresent()) {
			String msj = "El item de categoria Modulo de Desarrollo ya esta registrado con este Nombre";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(modDevService.save(moddev));
	}
	
	@GetMapping("/moddev/{id}")
	public ResponseEntity<?> getModdev(@PathVariable(value = "id") Long moddev_id){
		
		Optional<ModDevVo> modO = modDevService.findByID(moddev_id);
		
		if (!modO.isPresent()){
			String msj = "El item de categoria Modulo de Desarrollo con id "+ moddev_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.ok(modO);
	} 
	
	@PutMapping("/moddev/{id}/{keys}/{doc}")
	public ResponseEntity<?> updateModdev(@RequestBody ModDevVo moddev, @PathVariable(value = "id") Long moddev_id, @PathVariable String keys, @PathVariable String doc){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<ModDevVo> moddevOpti = modDevService.findByID(moddev_id);
		
		if (!moddevOpti.isPresent() && doc.equalsIgnoreCase("")) {
			String msj = "El item de categoria Modulo de Desarrollo con id "+ moddev_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
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
	
	@DeleteMapping("/moddev/delete/{id}/{keys}")
	public ResponseEntity<?> deleteModdev(@PathVariable(value = "id") Long id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		if (!modDevService.findByID(id).isPresent()) {
			String msj = "El item de categoria Modulo de Desarrollo con id " + id +" que desea eliminar no ha sido encontrado";
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		modDevService.deleteById(id);
		
		Optional<ModDevVo> item = modDevService.findByID(id);
		
		if (item.isPresent()) {
			
			String msj = "El item no se ha podido eliminar";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}else {
			String msj = "Item de categoria Otro eliminado con exito";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(msj);
		}
	}
	
	@GetMapping("/moddev")
	public List<ModDevVo> getAllModdev(){
		
		List<ModDevVo> moddevList = StreamSupport
				.stream(modDevService.findAll().spliterator(), false).collect(Collectors.toList());
		return moddevList;
	}
	
	@GetMapping("/moddev/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(modDevService.encontrarPorNombre(name));
	}
	
	@GetMapping("/moddev/type/{tipo}")
	public List<ModDevVo> getByType(@PathVariable String tipo){
		List<ModDevVo> moddevList = StreamSupport
				.stream(modDevService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return moddevList;
	}
	
	@GetMapping("/moddev/general/name/{name}")
	public List<ModDevVo> getByNameGeneral(@PathVariable String name){
		List<ModDevVo> moddevList = StreamSupport
				.stream(modDevService.encontarPorNombreGeneral(name).spliterator(), false).collect(Collectors.toList());
		return moddevList;
	}
    @GetMapping("/moddev/tipos")
    public List<String> getTypes(){
    	
    	List<String> moddevList = (List<String>) modDevService.obtenerTipos();
	    // This is a easter Egg BLESSED
	    String tipo = "";
	    List<String> list = new ArrayList<String>();
	    
	    for (int i = 0; i < moddevList.size(); i++) {
	    	
	    	if (tipo.equalsIgnoreCase(moddevList.get(i))) {
	    		tipo = moddevList.get(i);
			}else {
				list.add(moddevList.get(i));
				tipo = moddevList.get(i);
			}
		}
	    
	return moddevList;
    }
    
    @GetMapping("/moddev/general/id/{ids}")
   	public List<ModDevVo> getmoddevByIdGeneral(@PathVariable(value = "ids") Long moddev_id){
       	
       	List<ModDevVo> moddevList = StreamSupport
   				.stream(modDevService.encontrarPorIdGeneral(moddev_id).spliterator(), false).collect(Collectors.toList());
   		return moddevList;
   	}
}

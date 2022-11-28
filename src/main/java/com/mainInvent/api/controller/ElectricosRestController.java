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

import com.mainInvent.api.entity.ElectricosVo;
import com.mainInvent.api.service.IElectricosService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ElectricosRestController {

	@Autowired
	private IElectricosService electricosService;
	
	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	@PostMapping("/electricos/{keys}")
	public ResponseEntity<?> saveElectricos(@RequestBody ElectricosVo electricos, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<ElectricosVo> opElectric = electricosService.encontrarPorNombreItem(electricos.getNombre_parte_electricos());
				
		if (opElectric.isPresent()) {
			String msj = "El item de categoria Electricos ya esta registrado con este Nombre";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(electricosService.save(electricos));
	}
	
	
	@GetMapping("/electricos/{id}")
	public ResponseEntity<?> getElectricos(@PathVariable(value = "id") Long electricos_id){
		
		Optional<ElectricosVo> oElectricos = electricosService.findByID(electricos_id);
		
		if (!oElectricos.isPresent()){
			String msj = "El item de categoria Electricos con id "+ electricos_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.ok(oElectricos);
	}
	
	@PutMapping("/electricos/{id}/{keys}")
	public ResponseEntity<?> updateElectricos(@RequestBody ElectricosVo electricos, @PathVariable(value = "id") Long electricos_id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<ElectricosVo> electricosOpti = electricosService.findByID(electricos_id);
		
		if (!electricosOpti.isPresent()) {
			String msj = "El item de categoria Electricos con id "+ electricos_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		electricosOpti.get().setImagen_parte_electricos(electricos.getImagen_parte_electricos());
		electricosOpti.get().setDescripcion_parte_electricos(electricos.getDescripcion_parte_electricos());
		electricosOpti.get().setTipo_parte_electricos(electricos.getDescripcion_parte_electricos());
		electricosOpti.get().setCantidad_disponible_electricos(electricos.getCantidad_disponible_electricos());
		electricosOpti.get().setCantidad_consumida_electricos(electricos.getCantidad_consumida_electricos());
		electricosOpti.get().setUbicacion_parte_electricos(electricos.getUbicacion_parte_electricos());
		electricosOpti.get().setDatasheet_parte_electricos(electricos.getDatasheet_parte_electricos());
		electricosOpti.get().setNombre_parte_electricos(electricos.getNombre_parte_electricos());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(electricosService.save(electricosOpti.get()));
	}
	
	@DeleteMapping("/electricos/delete/{id}/{keys}")
	public ResponseEntity<?> deleteElectricos(@PathVariable(value = "id") Long id, @PathVariable String keys){
		
		if (!electricosService.findByID(id).isPresent()) {
			String msj = "El item de categoria Electricos con id " + id +" que desea eliminar no ha sido encontrado";
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		electricosService.deleteById(id);
		
		Optional<ElectricosVo> item = electricosService.findByID(id);
		
		if (item.isPresent()) {
			
			String msj = "El item no se ha podido eliminar";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}else {
			String msj = "Item de categoria Electricos eliminado con exito";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(msj);
		}
	}
	
	@GetMapping("/electricos")
	public List<ElectricosVo> getAllElectricos(){
		
		List<ElectricosVo> electricosList = StreamSupport
				.stream(electricosService.findAll().spliterator(), false).collect(Collectors.toList());
		return electricosList;
	}
	
	@GetMapping("/electricos/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(electricosService.encontrarPorNombreItem(name));
	}
	
	@GetMapping("/electricos/type/{tipo}")
	public List<ElectricosVo> getByType(@PathVariable String tipo){
		List<ElectricosVo> electricosList = StreamSupport
				.stream(electricosService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return electricosList;
	}
	
	@GetMapping("/electricos/general/name/{name}")
	public List<ElectricosVo> getByNameGeneral(@PathVariable String name){
		List<ElectricosVo> electricosList = StreamSupport
				.stream(electricosService.encontrarPorNombreGeneral(name).spliterator(), false).collect(Collectors.toList());
		return electricosList;
	}
    @GetMapping("/electricos/tipos")
    public List<String> getTypes(){
    	
	    List<String> electricosList = (List<String>) electricosService.obtenerTipos();
	    
	    String tipo = "";
	    
	    List<String> list = new ArrayList<String>();
	    
	    if (list.isEmpty()) {
			
	    	list.add("Crea una categoria nueva");
	    	
		}else {
			
			for (int i = 0; i < electricosList.size(); i++) {
		    	
		    	if (tipo.equalsIgnoreCase(electricosList.get(i))) {
		    		tipo = electricosList.get(i);
				}else {
					list.add(electricosList.get(i));
					tipo = electricosList.get(i);
				}
			}
			
		}
	    		
	    return list;
    }
    
    @GetMapping("/electricos/general/id/{ids}")
	public List<ElectricosVo> getElectricosByIdGeneral(@PathVariable(value = "ids") Long electricos_id){
    	
    	List<ElectricosVo> electricosList = StreamSupport
				.stream(electricosService.encontrarPorIdGeneral(electricos_id).spliterator(), false).collect(Collectors.toList());
		return electricosList;
	}
}
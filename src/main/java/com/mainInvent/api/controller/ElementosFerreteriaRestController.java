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

import com.mainInvent.api.entity.ElementosFerrerteriaVo;
import com.mainInvent.api.service.IElementosFerreteriaService;

@RestController
@RequestMapping("/api")
public class ElementosFerreteriaRestController {
	@Autowired
	private IElementosFerreteriaService eleFerreService;
	
	@PostMapping("/eleferre")
	public ResponseEntity<?> saveEleFerre(@RequestBody ElementosFerrerteriaVo eleferre){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(eleFerreService.save(eleferre));
	}
	
	@GetMapping("/eleferre/{id}")
	public ResponseEntity<?> getEleFerre(@PathVariable(value = "id") Long eleferre_id){
		
		Optional<ElementosFerrerteriaVo> oEleferre = eleFerreService.findByID(eleferre_id);
		
		if (!oEleferre.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oEleferre);
	} 
	
	@PutMapping("/eleferre/{id}")
	public ResponseEntity<?> updateEleFerre(@RequestBody ElementosFerrerteriaVo eleferre, @PathVariable(value = "id") Long eleferre_id){
		
		Optional<ElementosFerrerteriaVo> eleferreOpti = eleFerreService.findByID(eleferre_id);
		
		if(!eleferreOpti.isPresent()){
			return ResponseEntity.notFound().build();
        }
		
		eleferreOpti.get().setNombre_parte_elementosferreteria(eleferre.getNombre_parte_elementosferreteria());
		eleferreOpti.get().setImagen_parte_elementosferreteria(eleferre.getImagen_parte_elementosferreteria());
		eleferreOpti.get().setDescripcion_parte_elementosferreteria(eleferre.getDescripcion_parte_elementosferreteria());
		eleferreOpti.get().setTipo_parte_elementosferreteria(eleferre.getTipo_parte_elementosferreteria());
		eleferreOpti.get().setCantidad_disponible_elementosferreteria(eleferre.getCantidad_disponible_elementosferreteria());
		eleferreOpti.get().setCantidad_consumida_elementosferreteria(eleferre.getCantidad_consumida_elementosferreteria());
		eleferreOpti.get().setUbicacion_parte_elementosferreteria(eleferre.getUbicacion_parte_elementosferreteria());
		eleferreOpti.get().setDatasheet_parte_elementosferreteria(eleferre.getDatasheet_parte_elementosferreteria());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(eleFerreService.save(eleferreOpti.get()));
		
	}
	
	@DeleteMapping("/eleferre/{id}")
	public ResponseEntity<?> deleteEleFerre(@PathVariable(value = "id") Long id){
		if (!eleFerreService.findByID(id).isPresent()) {
			ResponseEntity.notFound().build();
		}
		eleFerreService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/eleferre")
	public List<ElementosFerrerteriaVo> getAllEleFerre(){
		
		List<ElementosFerrerteriaVo> eleferreList = StreamSupport
				.stream(eleFerreService.findAll().spliterator(), false).collect(Collectors.toList());
		return eleferreList;
	}
	
	@GetMapping("/eleferre/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
	  return ResponseEntity.ok(eleFerreService.encontrarPorNombre(name));
	}
	
	@GetMapping("/eleferre/type/{tipo}")
	public List<ElementosFerrerteriaVo> getByType(@PathVariable String tipo){
		List<ElementosFerrerteriaVo> eleferreList = StreamSupport
				.stream(eleFerreService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return eleferreList;
	}
}

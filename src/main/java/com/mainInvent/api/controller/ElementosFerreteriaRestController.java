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

import com.mainInvent.api.entity.ElementosFerrerteriaVo;
import com.mainInvent.api.service.IElementosFerreteriaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ElementosFerreteriaRestController {
	
	@Autowired
	private IElementosFerreteriaService eleFerreService;
	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	@PostMapping("/eleferre/{keys}")
	public ResponseEntity<?> saveEleFerre(@RequestBody ElementosFerrerteriaVo eleferre, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<ElementosFerrerteriaVo> otro = eleFerreService.encontrarPorNombreItem(eleferre.getNombre_parte_elementosferreteria());
		
		if (otro.isPresent()) {
			String msj = "El item de categoria Elementos Ferrerteria ya esta registrado con este Nombre";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(eleFerreService.save(eleferre));
	}
	
	@GetMapping("/eleferre/{id}")
	public ResponseEntity<?> getEleFerre(@PathVariable(value = "id") Long eleferre_id){
		
		Optional<ElementosFerrerteriaVo> oOtros = eleFerreService.findByID(eleferre_id);
		
		if (!oOtros.isPresent()){
			String msj = "El item de categoria Elementos Ferrerteria  con id "+ eleferre_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.ok(oOtros);
	} 
	
	@PutMapping("/eleferre/{id}/{keys}/{doc}")
	public ResponseEntity<?> updateEleFerre(@RequestBody ElementosFerrerteriaVo eleferre, @PathVariable(value = "id") Long eleferre_id, @PathVariable String keys, @PathVariable String doc){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<ElementosFerrerteriaVo> eleferreOpti = eleFerreService.findByID(eleferre_id);
		
		if (!eleferreOpti.isPresent() && doc.equalsIgnoreCase("")) {
			String msj = "El item de categoria Elementos Ferrerteria con id "+ eleferre_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
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
	
	@DeleteMapping("/eleferre/delete/{id}/{keys}")
	public ResponseEntity<?> deleteEleFerre(@PathVariable(value = "id") Long id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		if (!eleFerreService.findByID(id).isPresent()) {
			String msj = "El item de categoria Elementos Ferrerteria con id " + id +" que desea eliminar no ha sido encontrado";
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		eleFerreService.deleteById(id);
		
		Optional<ElementosFerrerteriaVo> item = eleFerreService.findByID(id);
		
		if (item.isPresent()) {
			
			String msj = "El item no se ha podido eliminar";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}else {
			String msj = "Item de categoria Elementos Ferrerteria eliminado con exito";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(msj);
		}
	}
	
	@GetMapping("/eleferre")
	public List<ElementosFerrerteriaVo> getAllEleFerre(){
		
		List<ElementosFerrerteriaVo> eleferreList = StreamSupport
				.stream(eleFerreService.findAll().spliterator(), false).collect(Collectors.toList());
		return eleferreList;
	}
	
	@GetMapping("/eleferre/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(eleFerreService.encontrarPorNombreItem(name));
	}
	
	@GetMapping("/eleferre/type/{tipo}")
	public List<ElementosFerrerteriaVo> getByType(@PathVariable String tipo){
		List<ElementosFerrerteriaVo> eleferreList = StreamSupport
				.stream(eleFerreService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return eleferreList;
	}
	
	@GetMapping("/eleferre/general/name/{name}")
	public List<ElementosFerrerteriaVo> getByNameGeneral(@PathVariable String name){
		List<ElementosFerrerteriaVo> eleferreList = StreamSupport
				.stream(eleFerreService.encontrarPorNombreGeneral(name).spliterator(), false).collect(Collectors.toList());
		return eleferreList;
	}

    @GetMapping("/eleferre/tipos")
    public List<String> getTypes(){
    	
    	List<String> martillosList = (List<String>) eleFerreService.obtenerTipos();
	    // This is a easter Egg BLESSED
	    String tipo = "";
	    List<String> list = new ArrayList<String>();
	    
	    for (int i = 0; i < martillosList.size(); i++) {
	    	
	    	if (tipo.equalsIgnoreCase(martillosList.get(i))) {
	    		tipo = martillosList.get(i);
			}else {
				list.add(martillosList.get(i));
				tipo = martillosList.get(i);
			}
		}
	return martillosList;
    }
    
    @GetMapping("/eleferre/general/id/{ids}")
	public List<ElementosFerrerteriaVo> getElectricosByIdGeneral(@PathVariable(value = "ids") Long eleferre_id){
    	
    	List<ElementosFerrerteriaVo> eleferreList = StreamSupport
				.stream(eleFerreService.encontrarPorIdGeneral(eleferre_id).spliterator(), false).collect(Collectors.toList());
		return eleferreList;
	}
}

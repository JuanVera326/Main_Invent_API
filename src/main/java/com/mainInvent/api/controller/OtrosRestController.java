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

import com.mainInvent.api.entity.OtrosVo;
import com.mainInvent.api.service.IOtrosService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class OtrosRestController {

    @Autowired
	private IOtrosService otrosService;
    
    String acces_key = "bWF0aWFzLm1hL25zZnc=";
    
	@PostMapping("/otros/{keys}")
	public ResponseEntity<?> saveOtros(@RequestBody OtrosVo otros, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<OtrosVo> otro = otrosService.encontrarPornombre(otros.getNombre_parte_otros());
		
		if (otro.isPresent()) {
			String msj = "El item de categoria Otro ya esta registrado con este Nombre";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(otrosService.save(otros));
	}
	
	
	@GetMapping("/otros/{id}")
	public ResponseEntity<?> getOtros(@PathVariable(value = "id") Long otros_id){
		
		Optional<OtrosVo> oOtros = otrosService.findByID(otros_id);
		
		if (!oOtros.isPresent()){
			String msj = "El item de categoria Otro con id "+ otros_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.ok(oOtros);
	}
	
	@PutMapping("/otros/{id}/{keys}")
	public ResponseEntity<?> updateOtros(@RequestBody OtrosVo otros, @PathVariable(value = "id") Long otros_id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
	
		Optional<OtrosVo> otrosOpti = otrosService.findByID(otros_id);
		
		if (!otrosOpti.isPresent()) {
			String msj = "El item de categoria Otro con id "+ otros_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		otrosOpti.get().setNombre_parte_otros(otros.getNombre_parte_otros());
		otrosOpti.get().setImagen_parte_otros(otros.getImagen_parte_otros());
		otrosOpti.get().setDescripcion_parte_otros(otros.getDescripcion_parte_otros());
		otrosOpti.get().setTipo_parte_otros(otros.getTipo_parte_otros());
		otrosOpti.get().setCantidad_disponible_otros(otros.getCantidad_disponible_otros());
		otrosOpti.get().setCantidad_consumida_otros(otros.getCantidad_consumida_otros());
		otrosOpti.get().setUbicacion_parte_otros(otros.getUbicacion_parte_otros());
		otrosOpti.get().setDatasheet_parte_otros(otros.getDatasheet_parte_otros());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(otrosService.save(otrosOpti.get()));
		
	}
	
	@DeleteMapping("/otros/delete/{id}/{keys}")
	public ResponseEntity<?> deleteOtros(@PathVariable(value = "id") Long id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		if (!otrosService.findByID(id).isPresent()) {
			String msj = "El item de categoria Otro con id " + id +" que desea eliminar no ha sido encontrado";
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		otrosService.deleteById(id);
		
		Optional<OtrosVo> item = otrosService.findByID(id);
		
		if (item.isPresent()) {
			
			String msj = "El item no se ha podido eliminar";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}else {
			String msj = "Item de categoria Otro eliminado con exito";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(msj);
		}
	}
	
	@GetMapping("/otros")
	public List<OtrosVo> getAllOtros(){
	
		List<OtrosVo> otrosList = StreamSupport
				.stream(otrosService.findAll().spliterator(), false).collect(Collectors.toList());
		return otrosList;
	}
	
	@GetMapping("/otros/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(otrosService.encontrarPornombre(name));
	}
	
	@GetMapping("/otros/type/{tipo}")
	public List<OtrosVo> getByType(@PathVariable String tipo){
		List<OtrosVo> otrosList = StreamSupport
				.stream(otrosService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return otrosList;
	}
	
	@GetMapping("/otros/general/name/{name}")
	public List<OtrosVo> getByNameGeneral(@PathVariable String name){
		List<OtrosVo> otrosList = StreamSupport
				.stream(otrosService.encontrarPorNombreGeneral(name).spliterator(), false).collect(Collectors.toList());
		return otrosList;
	}
}

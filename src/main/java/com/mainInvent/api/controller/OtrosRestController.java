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

import com.mainInvent.api.entity.OtrosVo;
import com.mainInvent.api.service.IOtrosService;

@RestController
@RequestMapping("/api")
public class OtrosRestController {

    @Autowired
	private IOtrosService otrosService;
	
	@PostMapping("/otros")
	public ResponseEntity<?> saveOtros(@RequestBody OtrosVo otros){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(otrosService.save(otros));
	}
	
	
	@GetMapping("/otros/{id}")
	public ResponseEntity<?> getOtros(@PathVariable(value = "id") Long otros_id){
		
		Optional<OtrosVo> oOtros = otrosService.findByID(otros_id);
		
		if (!oOtros.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oOtros);
	}
	
	@PutMapping("/otros/{id}")
	public ResponseEntity<?> updateOtros(@RequestBody OtrosVo otros, @PathVariable(value = "id") Long otros_id){
	
		Optional<OtrosVo> otrosOpti = otrosService.findByID(otros_id);
		
		if (!otrosOpti.isPresent()) {
			return ResponseEntity.notFound().build();
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
	
	@DeleteMapping("/otros/delete/{id}")
	public ResponseEntity<?> deleteOtros(@PathVariable(value = "id") Long id){
		if (!otrosService.findByID(id).isPresent()) {
			ResponseEntity.notFound().build();
		}
		
		otrosService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/otros")
	public List<OtrosVo> getAllOtros(){
	
		List<OtrosVo> otrosList = StreamSupport
				.stream(otrosService.findAll().spliterator(), false).collect(Collectors.toList());
		return otrosList;
	}
	
	@GetMapping("/otros/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		return ResponseEntity.ok(otrosService.encontrarPornombre(name));
	}
	
	@GetMapping("/otros/type/{tipo}")
	public List<OtrosVo> getByType(@PathVariable String tipo){
		List<OtrosVo> otrosList = StreamSupport
				.stream(otrosService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return otrosList;
	}
}

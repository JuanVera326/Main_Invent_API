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

import com.mainInvent.api.entity.ElectronicosVo;
import com.mainInvent.api.service.IElectronicosService;

@RestController
@RequestMapping("/api")
public class ElectronicosRestController {

  @Autowired
  private IElectronicosService electronicosService;
  
  @PostMapping("/electronicos")
  public ResponseEntity<?> saveElectronicos(@RequestBody ElectronicosVo electronicos){
	  
	  Optional<ElectronicosVo> electronicoOp = electronicosService.findByID(electronicos.getId_Comp());
		
		if (electronicoOp.isPresent()) {
			String msj = "El item de categoria Electronicos  ya esta registrado con este id";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(electronicosService.save(electronicos));
  }
  
  @GetMapping("/electronicos/{id}")
  public ResponseEntity<?> getElectronicos(@PathVariable(value = "id") Long electronicos_id ){
	  
	  Optional<ElectronicosVo> electronicosOp = electronicosService.findByID(electronicos_id);
		
		if (!electronicosOp.isPresent()){
			String msj = "El item de categoria Electronicos con id "+ electronicos_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.ok(electronicosOp);
  }
  
  @PutMapping("/electronicos/{id}")
  public ResponseEntity<?> updateElectronicos(@RequestBody ElectronicosVo electronicos, @PathVariable(value = "id") Long electronicos_id){
	  
	  Optional<ElectronicosVo> electronicosOpti = electronicosService.findByID(electronicos_id);
		
		if (!electronicosOpti.isPresent()) {
			String msj = "El item de categoria Electronicos con id "+ electronicos_id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
	  
	  electronicosOpti.get().setNombre_comp(electronicos.getNombre_comp());
	  electronicosOpti.get().setNumero_partefabricante_comp(electronicos.getNumero_partefabricante_comp());
	  electronicosOpti.get().setPinout_comp(electronicos.getPinout_comp());
	  electronicosOpti.get().setEsquematico_comp(electronicos.getPinout_comp());
	  electronicosOpti.get().setDescripcion_comp(electronicos.getDescripcion_comp());
	  electronicosOpti.get().setTipo_comp(electronicos.getTipo_comp());
	  electronicosOpti.get().setEncampsulado_comp(electronicos.getEncampsulado_comp());
	  electronicosOpti.get().setCantidad_disponible_comp(electronicos.getCantidad_disponible_comp());
	  electronicosOpti.get().setCantidad_consumida_comp(electronicos.getCantidad_consumida_comp());
	  electronicosOpti.get().setUbicacion_comp(electronicos.getUbicacion_comp());
	  electronicosOpti.get().setDatasheet_comp(electronicos.getDatasheet_comp());
	  
	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(electronicosService.save(electronicosOpti.get()));	  
  }
  
  @DeleteMapping("/electronicos/delete/{id}")
  public ResponseEntity<?> deleteElectronicos(@PathVariable(value = "id") Long id){
	  
	  if (!electronicosService.findByID(id).isPresent()) {
			String msj = "El item de categoria Electronicos con id " + id +" que desea eliminar no ha sido encontrado";
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
	  electronicosService.deleteById(id);
		
		Optional<ElectronicosVo> item = electronicosService.findByID(id);
		
		if (item.isPresent()) {
			
			String msj = "El item no se ha podido eliminar";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}else {
			String msj = "Item de categoria Electronicos eliminado con exito";
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(msj);
		}
  }
  
  @GetMapping("/electronicos")
  public List<ElectronicosVo> getAllElectronicos(){
	  
	  List<ElectronicosVo> electronicosList = StreamSupport
			  .stream(electronicosService.findAll().spliterator(), false).collect(Collectors.toList());
	  return electronicosList;
  }
  
  @GetMapping("/electronicos/name/{name}")
  public List<ElectronicosVo> getByName(@PathVariable String name){
	  
	  List<ElectronicosVo> usuariosList = StreamSupport
				.stream(electronicosService.encontrarPorNombre(name).spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
  }
  
  @GetMapping("/electronicos/type/{tipo}")
	public List<ElectronicosVo> getByType(@PathVariable String tipo){
		List<ElectronicosVo> electronicosList = StreamSupport
				.stream(electronicosService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return electronicosList;
  }
  
  @GetMapping("/electronicos/numfactory/{numeroFabricante}")
	public List<ElectronicosVo> getByNumerParteFabricante(@PathVariable(value = "numeroFabricante") String tipo){
		List<ElectronicosVo> electronicosList = StreamSupport
				.stream(electronicosService.encontrarPorNumParteFabricante(tipo).spliterator(), false).collect(Collectors.toList());
		return electronicosList;
  }
}

package com.mainInvent.api.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mainInvent.api.entity.Documentos_DatasheetsVo;
import com.mainInvent.api.service.IDocumentos_DatasheetsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class Documentos_DatasheetsRestController {

	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	@Autowired
	private IDocumentos_DatasheetsService fileAct;
	
	@PostMapping("/files/{id}/{name}/{keys}")
	public ResponseEntity<?> saveFile(@RequestBody MultipartFile file, @PathVariable String keys , @PathVariable Long id , @PathVariable String name){
		
		
		Documentos_DatasheetsVo pdf = new Documentos_DatasheetsVo();
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		if (!file.isEmpty()) {
			
			try {
			
				byte[] bytes = file.getBytes();
				
				pdf.setId_doc("" + name + id);
				pdf.setFile(bytes);
				
				fileAct.save(pdf);
				
			} catch (Exception e) {
				
				e.printStackTrace();
					
			}
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pdf);
			
		}else {
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

		}
				
	}
	
	
	@GetMapping("/files/{id}")
	public ResponseEntity<?> getFile(@PathVariable String id) throws IOException{
		
		Optional<Documentos_DatasheetsVo> file = fileAct.findByID(id);
		
		if (!file.isPresent()){
			String msj = "El item de categoria Electricos con id "+ id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(file);
	}
	
	@DeleteMapping("/files/{id}/{keys}")
	public ResponseEntity<?> delFiles(@PathVariable String id, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<Documentos_DatasheetsVo> file = fileAct.findByID(id);
		
		if (!file.isPresent()){
			String msj = "Error";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		fileAct.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
	}
}

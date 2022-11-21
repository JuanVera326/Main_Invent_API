package com.mainInvent.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

					
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pdf);
	}
	
	
	@GetMapping("/files/{id}")
	public ResponseEntity<?> getElectricos(@PathVariable(value = "id") Long id_file){
		
		Optional<Documentos_DatasheetsVo> file = fileAct.findByID(id_file);
		
		if (!file.isPresent()){
			String msj = "El item de categoria Electricos con id "+ id_file +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.ok(file);
	}
	

}

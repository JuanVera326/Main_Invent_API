package com.mainInvent.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mainInvent.api.entity.Documentos_DatasheetsVo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class Documentos_DatasheetsRestController {

	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	
	@PostMapping("/files/{id}/{name}/{keys}")
	public ResponseEntity<?> saveFile(@RequestBody MultipartFile file, @PathVariable String keys , @PathVariable Long id , @PathVariable String name){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		if (!file.isEmpty()) {
			
			try {
				
				byte[] bytes = file.getBytes();
			
				Documentos_DatasheetsVo pdf = new Documentos_DatasheetsVo();
				
				pdf.setId_doc("" + name + id);
				pdf.setFile(bytes);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

					
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}

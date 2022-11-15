package com.mainInvent.api.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mainInvent.api.service.IDocumentos_DatasheetsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class Documentos_DatasheetsRestController {
	
	@Autowired
	private IDocumentos_DatasheetsService filesService;
	
	String acces_key = "bWF0aWFzLm1hL25zZnc=";
	
	
	@PostMapping("/files/{keys}")
	public ResponseEntity<?> saveFile(@RequestBody MultipartFile file, @PathVariable String keys , @PathVariable Long id){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		String folder = ".//src//main//resources//files//";
		
		if (!file.isEmpty()) {
			
			try {
				
				byte[] bytes = file.getBytes();
				Path path = Paths.get(folder + file.getOriginalFilename());
				Files.write(path,bytes);
			
				Documentos_DatasheetsVo pdf = new Documentos_DatasheetsVo();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

					
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}

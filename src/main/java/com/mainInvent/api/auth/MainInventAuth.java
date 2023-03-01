package com.mainInvent.api.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainInvent.api.dto.AuthDto;
import com.mainInvent.api.dto.UsuarioDto;
import com.mainInvent.api.entity.UsuarioVo;
import com.mainInvent.api.service.IUsuarioService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class MainInventAuth {
	
	@Autowired
	private IUsuarioService authUser;
	
	@PostMapping("/auth")
	public ResponseEntity<?> setAuth(@RequestBody AuthDto user){
		
		Optional<UsuarioVo> userAuth = authUser.encontrarPorCorreo(user.getEmail());
		
		try {
			
			if (userAuth.isEmpty()) {
				
				String msj = "Correo Incorrecto";
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
				
			}else {
				
				
				if (user.getPassword().equals(userAuth.get().getPassword())) {
					
					UsuarioDto userAuthAccepted = new UsuarioDto( userAuth.get().getNombre(),
							userAuth.get().getApellido(), userAuth.get().getCargo(), userAuth.get().getImagen(),
							userAuth.get().getEdad(), userAuth.get().getRol(), userAuth.get().getCorreo(), 
							userAuth.get().getEstado(),userAuth.get().getId(), null);
					
					if ( userAuth.get().getRol() == 1 || userAuth.get().getRol() == 3 ) {
						userAuthAccepted.setConfig_ubi(userAuth.get().getConfig_ubi());
					}
					
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(userAuthAccepted);
					
				}
				String msj = "Contraseña Incorrecta";
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			}
			
		} catch (Exception e) {
			
			String msj = "Denegado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
			
		}
		
	}

}

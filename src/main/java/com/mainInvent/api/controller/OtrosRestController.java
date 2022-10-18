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
    
	String acces_key = "TXkgbmFtZSBpcyBXYWx0ZXIgSGFydHdlbGwgV2hpdGUuIEkgbGl2ZSBhdCAzMDggTmVncmEgQXJyb3lvIExhbmUsIEFsYnVxdWVycXVlLCBOZXcgTWV4aWNvLCA4NzEwNC4gVGhpcyBpcyBteSBjb25mZXNzaW9uLiBJZiB5b3UncmUgd2F0Y2hpbmcgdGhpcyB0YXBlLCBJJ20gcHJvYmFibHkgZGVhZCwgbXVyZGVyZWQgYnkgbXkgYnJvdGhlci1pbi1sYXcgSGFuayBTY2hyYWRlci4gSGFuayBoYXMgYmVlbiBidWlsZGluZyBhIG1ldGggZW1waXJlIGZvciBvdmVyIGEgeWVhciBub3cgYW5kIHVzaW5nIG1lIGFzIGhpcyBjaGVtaXN0LiBTaG9ydGx5IGFmdGVyIG15IDUwdGggYmlydGhkYXksIEhhbmsgY2FtZSB0byBtZSB3aXRoIGEgcmF0aGVyLCBzaG9ja2luZyBwcm9wb3NpdGlvbi4gSGUgYXNrZWQgdGhhdCBJIHVzZSBteSBjaGVtaXN0cnkga25vd2xlZGdlIHRvIGNvb2sgbWV0aGFtcGhldGFtaW5lLCB3aGljaCBoZSB3b3VsZCB0aGVuIHNlbGwgdXNpbmcgaGlzIGNvbm5lY3Rpb25zIGluIHRoZSBkcnVnIHdvcmxkLiBDb25uZWN0aW9ucyB0aGF0IGhlIG1hZGUgdGhyb3VnaCBoaXMgY2FyZWVyIHdpdGggdGhlIERFQS4gSSB3YXMuLi4gYXN0b3VuZGVkLCBJLi4uIEkgYWx3YXlzIHRob3VnaHQgdGhhdCBIYW5rIHdhcyBhIHZlcnkgbW9yYWwgbWFuIGFuZCBJIHdhcy4uLiB0aHJvd24sIGNvbmZ1c2VkLCBidXQgSSB3YXMgYWxzbyBwYXJ0aWN1bGFybHkgdnVsbmVyYWJsZSBhdCB0aGUgdGltZSwgc29tZXRoaW5nIGhlIGtuZXcgYW5kIHRvb2sgYWR2YW50YWdlIG9mLiBJIHdhcyByZWVsaW5nIGZyb20gYSBjYW5jZXIgZGlhZ25vc2lzIHRoYXQgd2FzIHBvaXNlZCB0byBiYW5rcnVwdCBteSBmYW1pbHkuIEhhbmsgdG9vayBtZSBvbiBhIHJpZGUgYWxvbmcsIGFuZCBzaG93ZWQgbWUganVzdCBob3cgbXVjaCBtb25leSBldmVuIGEgc21hbGwgbWV0aCBvcGVyYXRpb24gY291bGQgbWFrZS4gQW5kIEkgd2FzIHdlYWsuIEkgZGlkbid0IHdhbnQgbXkgZmFtaWx5IHRvIGdvIGludG8gZmluYW5jaWFsIHJ1aW4gc28gSSBhZ3JlZWQuIEV2ZXJ5IGRheSwgSSB0aGluayBiYWNrIGF0IHRoYXQgbW9tZW50IHdpdGggcmVncmV0LiBJIHF1aWNrbHkgcmVhbGl6ZWQgdGhhdCBJIHdhcyBpbiB3YXkgb3ZlciBteSBoZWFkLCBhbmQgSGFuayBoYWQgYSBwYXJ0bmVyLCBhIG1hbiBuYW1lZCBHdXN0YXZvIEZyaW5nLCBhIGJ1c2luZXNzbWFuLiBIYW5rIGVzc2VudGlhbGx5IHNvbGQgbWUgaW50byBzZXJ2aXR1ZGUgdG8gdGhpcyBtYW4sIGFuZCB3aGVuIEkgdHJpZWQgdG8gcXVpdCwgRnJpbmcgdGhyZWF0ZW5lZCBteSBmYW1pbHkuIEkgZGlkbid0IGtub3cgd2hlcmUgdG8gdHVybi4gRXZlbnR1YWxseSwgSGFuayBhbmQgRnJpbmcgaGFkIGEgZmFsbGluZyBvdXQuIEZyb20gd2hhdCBJIGNhbiBnYXRoZXIsIEhhbmsgd2FzIGFsd2F5cyBwdXNoaW5nIGZvciBhIGdyZWF0ZXIgc2hhcmUgb2YgdGhlIGJ1c2luZXNzLCB0byB3aGljaCBGcmluZyBmbGF0bHkgcmVmdXNlZCB0byBnaXZlIGhpbSwgYW5kIHRoaW5ncyBlc2NhbGF0ZWQuIEZyaW5nIHdhcyBhYmxlIHRvIGFycmFuZ2UsIHVoIEkgZ3Vlc3MgSSBndWVzcyB5b3UgY2FsbCBpdCBhICJoaXQiIG9uIG15IGJyb3RoZXItaW4tbGF3LCBhbmQgZmFpbGVkLCBidXQgSGFuayB3YXMgc2VyaW91c2x5IGluanVyZWQsIGFuZCBJIHdvdW5kIHVwIHBheWluZyBoaXMgbWVkaWNhbCBiaWxscyB3aGljaCBhbW91bnRlZCB0byBhIGxpdHRsZSBvdmVyICQxNzcsMDAwLiBVcG9uIHJlY292ZXJ5LCBIYW5rIHdhcyBiZW50IG9uIHJldmVuZ2UsIHdvcmtpbmcgd2l0aCBhIG1hbiBuYW1lZCBIZWN0b3IgU2FsYW1hbmNhLCBoZSBwbG90dGVkIHRvIGtpbGwgRnJpbmcsIGFuZCBkaWQgc28uIEluIGZhY3QsIHRoZSBib21iIHRoYXQgaGUgdXNlZCB3YXMgYnVpbHQgYnkgbWUsIGFuZCBoZSBnYXZlIG1lIG5vIG9wdGlvbiBpbiBpdC4gSSBoYXZlIG9mdGVuIGNvbnRlbXBsYXRlZCBzdWljaWRlLCBidXQgSSdtIGEgY293YXJkLiBJIHdhbnRlZCB0byBnbyB0byB0aGUgcG9saWNlLCBidXQgSSB3YXMgZnJpZ2h0ZW5lZC4gSGFuayBoYWQgcmlzZW4gaW4gdGhlIHJhbmtzIHRvIGJlY29tZSB0aGUgaGVhZCBvZiB0aGUgQWxidXF1ZXJxdWUgREVBLCBhbmQgYWJvdXQgdGhhdCB0aW1lLCB0byBrZWVwIG1lIGluIGxpbmUsIGhlIHRvb2sgbXkgY2hpbGRyZW4gZnJvbSBtZS4gRm9yIDMgbW9udGhzIGhlIGtlcHQgdGhlbS4gTXkgd2lmZSwgd2hvIHVwIHVudGlsIHRoYXQgcG9pbnQsIGhhZCBubyBpZGVhIG9mIG15IGNyaW1pbmFsIGFjdGl2aXRpZXMsIHdhcyBob3JyaWZpZWQgdG8gbGVhcm4gd2hhdCBJIGhhZCBkb25lLCB3aHkgSGFuayBoYWQgdGFrZW4gb3VyIGNoaWxkcmVuLiBXZSB3ZXJlIHNjYXJlZC4gSSB3YXMgaW4gSGVsbCwgSSBoYXRlZCBteXNlbGYgZm9yIHdoYXQgSSBoYWQgYnJvdWdodCB1cG9uIG15IGZhbWlseS4gUmVjZW50bHksIEkgdHJpZWQgb25jZSBhZ2FpbiB0byBxdWl0LCB0byBlbmQgdGhpcyBuaWdodG1hcmUsIGFuZCBpbiByZXNwb25zZSwgaGUgZ2F2ZSBtZSB0aGlzLiBJIGNhbid0IHRha2UgdGhpcyBhbnltb3JlLiBJIGxpdmUgaW4gZmVhciBldmVyeSBkYXkgdGhhdCBIYW5rIHdpbGwga2lsbCBtZSwgb3Igd29yc2UsIGh1cnQgbXkgZmFtaWx5LiBJLi4uIEFsbCBJIGNvdWxkIHRoaW5rIHRvIGRvIHdhcyB0byBtYWtlIHRoaXMgdmlkZW8gaW4gaG9wZSB0aGF0IHRoZSB3b3JsZCB3aWxsIGZpbmFsbHkgc2VlIHRoaXMgbWFuLCBmb3Igd2hhdCBoZSByZWFsbHkgaXMu";
	
	@PostMapping("/otros/{keys}")
	public ResponseEntity<?> saveOtros(@RequestBody OtrosVo otros, @PathVariable String keys){
		
		if (!keys.equals(acces_key)) {
			String msj = "No Autorizado";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msj);
		}
		
		Optional<OtrosVo> otro = otrosService.findByID(otros.getId_parte_otros());
		
		if (otro.isPresent()) {
			String msj = "El item de categoria Otro ya esta registrado con este id";
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
	public List<OtrosVo> getByName(@PathVariable String name){
		
		List<OtrosVo> usuariosList = StreamSupport
				.stream(otrosService.encontrarPornombre(name).spliterator(), false).collect(Collectors.toList());
		
		return usuariosList;
	}
	
	@GetMapping("/otros/type/{tipo}")
	public List<OtrosVo> getByType(@PathVariable String tipo){
		List<OtrosVo> otrosList = StreamSupport
				.stream(otrosService.encontrarPorTipo(tipo).spliterator(), false).collect(Collectors.toList());
		return otrosList;
	}
}

 package pe.net.yallerco.consumir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.net.yallerco.consumir.model.entity.Pais;
import pe.net.yallerco.consumir.service.PaisesService;

@RestController
@RequestMapping("/pais")
public class PaisesController {
	
	@Autowired
	PaisesService service;
	
	@GetMapping(value="/paises",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paises() {
		return service.obtenerPaises();
	}
	@GetMapping(value="/paises/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paises(@PathVariable("name") String name) {
		return service.buscarPaises(name);
	}
	
	@GetMapping(value="/listapaises",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> ListaPaises() {
		return service.obtenerListaPaises();
	}
	
	//CREAR
	@GetMapping("/agregar/{nombrePais}/{capital}/{codigo}"/* path="", consumes={MediaType.APPLICATION_JSON_VALUE} */)
	public Pais agregar(
			@PathVariable("nombrePais") String nombrePais, 
			@PathVariable("capital") String capital,
			@PathVariable("codigo") String codigo
			){
		return null; //paisService.agregar(nombrePais, capital,codigo);
	}
}

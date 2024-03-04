package pe.net.yallerco.consumir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.net.yallerco.consumir.model.entity.Pais;
import pe.net.yallerco.consumir.service.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	PaisService service;

	// CREAR
	@PostMapping("/agregar/{nombrePais}/{capital}/{codigo}")
//	public List<Pais> agregar(
			public void agregar(
			@PathVariable("nombrePais") String nombrePais, 
			@PathVariable("capital") String capital,
			@PathVariable("codigo") String codigo
			) {
//		return service.agregar(nombrePais, capital, codigo);
		service.agregar(nombrePais, capital, codigo);
	}
}

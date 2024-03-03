package pe.net.yallerco.consumir.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pe.net.yallerco.consumir.model.entity.Paiss;
import pe.net.yallerco.consumir.model.entity.Persona;
import pe.net.yallerco.consumir.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	//usando Rest Template para consumir a otro servicio
    @Autowired
    RestTemplate restTemplate;
    
    String urlBase = "http://localhost:4444";
    String urlPais = "http://localhost:8030/proveedor/pais";
    
    
//    @GetMapping(value = "/personas/{pais}/capital}/{codigo}", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public List<Persona> registrarPersona1(
//			@PathVariable("pais") String pais, 
//			@PathVariable("capital") String capital,
//			@PathVariable("codigo") String codigo) {
//
//		Paiss paiss = new Paiss(pais, capital,codigo);
//		restTemplate.postForObject(urlPais, "contactos", Paiss);
//		Persona[] personas = restTemplate.getForObject(url+"/contactos", Persona[].class);
//		CompletableFuture<List<Paiss>> resultado = personaService.llamarServicio(paiss);
//		return Arrays.asList(personas);
//	}
    
//    @GetMapping(value = "/personas/{nombre}/{email}/{edad}", produces = { MediaType.APPLICATION_JSON_VALUE })
//   	public List<Persona> registrarPersona2(
//   			@PathVariable("nombre") String nombre, 
//   			@PathVariable("email") String email,
//   			@PathVariable("edad") int edad) {
//
//   		Persona persona = new Persona(nombre, email, edad);
//   		restTemplate.postForObject(url, "contactos", persona);
//   		Persona[] personas = restTemplate.getForObject(url+"/contactos", Persona[].class);
//   		CompletableFuture<List<Persona>> resultado = personaService.llamarServicio(persona);
//   		return Arrays.asList(personas);
//   	}
	
	//**********************************************************************************
	//************************RECIBE Y POSTERIOR CONSULTA A OTRO MICROSERVICIO *********
    //*********************** USANDO TAMBIEN ASINCRONIA ******************************

	// http://localhost:3333/personas/David/davidya@gmail.com/36

	@GetMapping(value = "/personas/{nombre}/{email}/{edad}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Persona> registrarPersona(
			@PathVariable("nombre") String nombre, 
			@PathVariable("email") String email,
			@PathVariable("edad") int edad) {

		Persona persona = new Persona(nombre, email, edad);
		//llamando al metodo asincrono, digamos que demore 8 seg.
		CompletableFuture<List<Persona>> resultado = personaService.llamarServicio(persona);
		//haciendo otra cosa, y lo de arriba esta corriendo en otro hilo
		for (int i = 0; i < 50; i++) {
			System.out.println("esperando"+ i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return resultado.get(); //eso si cuando para hacer este return si tiene que esperar que el hilo termine
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//**********************************************************************************
		//************************RECIBE Y POSTERIOR CONSULTA A OTRO MICROSERVICIO *********

	// busqueda de persona a traves de un rando de edades
	@GetMapping(value = "/personas/{edad1}/{edad2}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Persona> buscarEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {
		Persona[] personas = restTemplate.getForObject(urlBase + "/contactos", Persona[].class);
		return Arrays.stream(personas).filter(p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
				.collect(Collectors.toList());
	}

//    
//    String url = "http://localhost:3333/cursos";
//    //recupera todos los cursos
//    Inmueble[] inmuebles = restTemplate.getForObject(url, Inmueble[].class);
//    //busca un curso a partir de su nombre
//    //Inmueble inm = restTemplate.getForObject(url + "/{name}", Inmueble.class, "Java");
//    
//    //actualiza y eliminar
//    String url = "http://localhost:3333/curso";
//    Inmueble inmueble = restTemplate.getForObject(url, "/{name}", Inmueble.class, "Java");
//    inmueble.setDuration(70);
//    restTemplate.put(url,inmueble);//actualiza curso de java
//    restTemplate.delete(url + "/{name}", "Angular8"); //elimina curso por nombre
//    
//    //--------------usando metodo exchange, devuelve resultados --------
//    
//    Inmueble inmueble = restTemplate.getForObject(url, "/{name}", Inmueble.class,"Java");
//    inmueble.setDuration(70);
//    ResponseEntity<Inmueble[]> rp = tmp.exchange(url,HttpMethod.PUT, new HttpEntity<Inmueble>(inmueble), Inmueble.class) ;
//    Inmueble[] inmuebles  = rp.getBody();
//    
//    //delete

}

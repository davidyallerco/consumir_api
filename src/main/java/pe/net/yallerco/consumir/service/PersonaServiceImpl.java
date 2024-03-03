package pe.net.yallerco.consumir.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pe.net.yallerco.consumir.model.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	//usando Rest Template para consumir a otro servicio
    @Autowired
    RestTemplate restTemplate;
    
    String urlBase = "http://localhost:4444";
  //**********************************************************************************
  	//************************ CONSULTA A OTRO MICROSERVICIO *********
	
	//el tipo CompletableFuture permite al cliente controlar la resuesta
	//usado para asincronia
	@Async
	public CompletableFuture<List<Persona>> llamarServicio(Persona persona){
		//restTemplate.getForObject.....
		//llamar a otro rest, puede ser otro microservicio
    	restTemplate.postForLocation(urlBase+"/contactos", persona);
    	Persona[] personas = restTemplate.getForObject(urlBase+"/contactos", Persona[].class);
    	return CompletableFuture.completedFuture(Arrays.asList(personas));
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findByLikeNombre(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona add(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona update(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

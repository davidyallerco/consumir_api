package pe.net.yallerco.consumir.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import pe.net.yallerco.consumir.model.entity.Persona;

public interface PersonaService {
	
	public CompletableFuture<List<Persona>> llamarServicio(Persona persona);
	
	List<Persona> findAll();
	
	List<Persona> findByLikeNombre(Persona persona);
	
	Optional<Persona> findById(Long id);
	
	Persona add(Persona persona);

	Persona update(Persona persona);

	Persona delete(Long id);

}

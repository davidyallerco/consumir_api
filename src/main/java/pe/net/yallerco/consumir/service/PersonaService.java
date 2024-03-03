package pe.net.yallerco.consumir.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import pe.net.yallerco.consumir.model.entity.Persona;

public interface PersonaService {
	
	public CompletableFuture<List<Persona>> llamarServicio(Persona persona);

}

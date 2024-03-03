package pe.net.yallerco.consumir.model.dao;

import org.springframework.data.repository.CrudRepository;

import pe.net.yallerco.consumir.model.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}

package pe.net.yallerco.consumir.service;

import java.util.List;

import pe.net.yallerco.consumir.model.entity.Pais;

public interface PaisesService {

	List<Pais> obtenerPaises();
	List<Pais> buscarPaises(String name);
	List<Pais> obtenerListaPaises();
	
	public void agregar(String nombrePais,String capital,String codigo);

}

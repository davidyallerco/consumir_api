package pe.net.yallerco.consumir.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.net.yallerco.consumir.model.entity.Pais;
import pe.net.yallerco.consumir.model.entity.Paiss;

public class PaisesServiceImpl implements PaisesService{
	
	String urlBase = "https://restcountries.eu/rest/v2/all";
	
	String url = "http://localhost:8030/proveedor/pais/";
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Pais> obtenerPaises() {
		String resultado = restTemplate.getForObject(urlBase, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Pais> paises = new ArrayList<>();
		return null;
	}

	@Override
	public List<Pais> buscarPaises(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pais> obtenerListaPaises() {
		
//		Pais[]  paises = restTemplate.getForObject(url, Pais[].class);
		
		return null;
	}

	@Override
	public  void agregar(String nombrePais, String capital, String codigo) {
		Paiss paiss = new Paiss();
		paiss.setPais(nombrePais);
		paiss.setCapital(capital);
		paiss.setCodigo(codigo);
		
		restTemplate.postForLocation(url+"/agregar", paiss);
		//Paiss[] paises = restTemplate.getForObject(url, responseType)
		//return null;
	}
	

}

package pe.net.yallerco.consumir.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import pe.net.yallerco.consumir.model.entity.Pais;

@Service
public class PaisServiceImpl implements PaisService{
	
	
	
	
	
	@Autowired
	WebClient webClient;
	
	String url = "http://localhost:8030/proveedor/pais/";

	

	@Override
//	public  List<Pais> agregar(String nombrePais, String capital, String codigo) {
		public  void agregar(String nombrePais, String capital, String codigo) {
		Pais pais = new Pais();
		pais.setPais(nombrePais);
		pais.setCapital(capital);
		pais.setCodigo(codigo);
		
		webClient
		.post()
		.uri(url+"/crear")
		.contentType(MediaType.APPLICATION_JSON)
		.bodyValue(pais)
		.retrieve()
		.bodyToMono(Void.class)
		.block();
		
//		Pais[] paises = webClient
//		.get()
//		.uri(url+"/crear")
//		.retrieve()
//		.bodyToMono(Pais[].class)
//		.block();
		
//		return Arrays.asList(paises);
	}
	

}

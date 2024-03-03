package pe.net.yallerco.consumir.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	
	private String nombre;
	private String email;
	private int edad;

}

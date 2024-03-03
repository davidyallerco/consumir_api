package pe.net.yallerco.consumir.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@EnableAsync // Habilita la capacidad de ejecucion asíncrona
@Configuration
public class Config {

	// GET con RestTemplate , para consumir servicios a otro microservicio, aqui se
	// comportaria como un cliente
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

	// Implementacion de Executor para la ejecucion asincrona
	@Bean
	public Executor executor() {
		return new ThreadPoolTaskExecutor();// ejecuta tareas en segundo plano
	}

}

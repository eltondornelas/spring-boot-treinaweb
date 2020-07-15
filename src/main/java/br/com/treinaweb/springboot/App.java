package br.com.treinaweb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		/* configurando a meta de build:
		 * 1 - botão direito no projeto
		 * 2 - Run
		 * 3 - Maven build...
		 * 4 - no label Goals digitar no input: spring-boot:run
		 * 5 - run
		 * 
		 * OBS: os plugins do parent pom e do build habilitam o host deploy, reiniciando automaticamente, não precisa dar stop!!!
		 */
	}
}

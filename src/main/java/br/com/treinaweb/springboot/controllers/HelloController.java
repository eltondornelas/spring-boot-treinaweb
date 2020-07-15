package br.com.treinaweb.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("mensagem", "Olá Spring Boot com Thymeleaf");
		
		return "index";
		// o retorno é o nome do html que deseja ser renderizado
		
		/* necessário fazer algumas configurações que ficarão no arquivo application.properties 
		 * que é o arquivo procurado por padrão pelo spring.
		 * 
		 * por padrão o thymeleaf procura primeiro por uma pasta chamada "templates" que fica em src/main/resources, ou seja,
		 * ao retornar o "index" ele vai procurar em src/main/resources/templates
		 */
	}
}

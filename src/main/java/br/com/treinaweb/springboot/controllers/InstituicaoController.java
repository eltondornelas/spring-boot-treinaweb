package br.com.treinaweb.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.springboot.entidades.Instituicao;
import br.com.treinaweb.springboot.repositories.InstituicaoRepository;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView resultado = new ModelAndView("instituicao/index");

		List<Instituicao> instituicoes = instituicaoRepository.findAll();
		resultado.addObject("instituicoes", instituicoes);

		return resultado;
	}

	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("instituicao/inserir");
		resultado.addObject("instituicao", new Instituicao());

		return resultado;
	}
	
	
	@PostMapping("/inserir")
	public String inserir(Instituicao instituicao) {
		instituicaoRepository.save(instituicao);
		
		return "redirect:/instituicoes/index";
	}
}

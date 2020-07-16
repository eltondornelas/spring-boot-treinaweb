package br.com.treinaweb.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		// new ModelAndView("instituicao/index") é como estivesse redirecionando para templates/instituicao/index.html

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
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Instituicao instituicao = instituicaoRepository.getOne(id);
		
		ModelAndView resultado = new ModelAndView("instituicao/editar");
		resultado.addObject("instituicao", instituicao);
		
		return resultado;
	}
	
	@PostMapping("/editar")
	public String editar(Instituicao instituicao) {
		instituicaoRepository.save(instituicao);
		
		return "redirect:/instituicoes/index";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		instituicaoRepository.delete(id);
		
		return "redirect:/instituicoes/index";
	}
	
	@GetMapping({"/pesquisarPorNome/{nome}", "/pesquisarPorNome/"})
	public @ResponseBody List<Instituicao> pesquisarPorNome(@PathVariable Optional<String> nome) {
//		esse GetMapping funciona para ambas rotas, caso o param "nome" venha em branco ele vai concatenar transformando na segunda rota, evitando possíveis erros
//		como o param é opcional, é interessante utilizar o Optional para encapsular possíveis situações de parametros
//		o ResponseBody vai serializar a lista dentro da resposta da requisição para um json
//		o formato de retorno pode ser alterado no cliente (browser) pelo content
		
		if (nome.isPresent()) {
			return instituicaoRepository.findByNomeContaining(nome.get());
		} else {
			return instituicaoRepository.findAll();
		}
	}
}

package br.com.treinaweb.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springboot.entidades.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

	List<Instituicao> findByNomeContaining(String nome);
}

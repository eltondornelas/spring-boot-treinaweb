package br.com.treinaweb.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springboot.entidades.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

}

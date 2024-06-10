package br.com.aula.WebServiceExemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aula.WebServiceExemplo.model.entity.JogadorTime;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Integer> {

	JogadorTime udfJogadorIdade(int codigo);
	
}

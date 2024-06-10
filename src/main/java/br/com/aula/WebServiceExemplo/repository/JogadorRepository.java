package br.com.aula.WebServiceExemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aula.WebServiceExemplo.model.entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

	List<Jogador> findJogadoresDataConv();
	Jogador findJogadorDataConv(int codigo);
	
}

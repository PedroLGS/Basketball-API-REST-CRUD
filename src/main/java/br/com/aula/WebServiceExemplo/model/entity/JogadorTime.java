package br.com.aula.WebServiceExemplo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "JogadorTime")
@NamedNativeQuery(
		name = "JogadorTime.udfJogadorIdade",
		query = "SELECT codigo, nomeJogador, sexo, altura, dt_nasc, idade, id, nome, cidade"
				+ " FROM fn_jogadoridade(?1)",
		resultClass = JogadorTime.class
)
public class JogadorTime {
	
	@Id
	@Column
	private int codigo;
	@Column
	private String nomeJogador;
	@Column
	private String sexo;
	@Column
	private float altura;
	@Column
	private String dt_nasc;
	@Column
	private int idade;
	@Column
	private int id;
	@Column
	private String nome;
	@Column
	private String cidade;

}

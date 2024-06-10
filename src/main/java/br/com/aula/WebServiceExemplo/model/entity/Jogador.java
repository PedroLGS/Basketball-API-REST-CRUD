package br.com.aula.WebServiceExemplo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Jogador")
@NamedNativeQuery(
		name = "Jogador.findJogadoresDataConv",
		query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura,"
				+" CONVERT(CHAR(10), j.dt_nasc, 103) AS dt_nasc, j.id_time,"
				+" t.id, t.nome, t.cidade"
				+" FROM jogador j, times t"
				+" WHERE j.id_time = t.id",
		resultClass = Jogador.class
)
@NamedNativeQuery(
		name = "Jogador.findJogadorDataConv",
		query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura,"
				+" CONVERT(CHAR(10), j.dt_nasc, 103) AS dt_nasc, j.id_time,"
				+" t.id, t.nome, t.cidade"
				+" FROM jogador j, times t"
				+" WHERE j.id_time = t.id"
				+" AND j.codigo = ?1",
		resultClass = Jogador.class
)
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@ManyToOne(targetEntity = Times.class)
	@JoinColumn(name = "id_time")
	private Times times;

}

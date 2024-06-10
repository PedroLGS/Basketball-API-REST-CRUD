package br.com.aula.WebServiceExemplo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JogadorDTO {
	
	private int codigo;
	private String nomeJogador;
	private String sexo;
	private float altura;
	private String dt_nasc;
	private int idade;
	private TimesDTO times;

}

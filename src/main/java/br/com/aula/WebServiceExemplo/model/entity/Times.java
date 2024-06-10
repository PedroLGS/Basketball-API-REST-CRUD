package br.com.aula.WebServiceExemplo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Times")
@NamedStoredProcedureQuery(
		name = "Times.spCrudTimes",
		procedureName = "sp_crudtimes",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "cod", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nome", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "cidade", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "saida", type = String.class)
		}

)
public class Times {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String nome;
	@Column
	private String cidade;
	@Transient
	private String cod;
	@Transient
	private String saida;
}

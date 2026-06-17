package br.senac.sp.guiarestaurante.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PratoDestaque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToOne
	private TipoPrato tipo;
	private String descricao;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Restaurante restaurante;
	private String avaliacao;
	private String foto;
}

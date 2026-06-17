package br.senac.sp.guiarestaurante.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comentario;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar data;
	private int nota;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Restaurante restaurante;
	@ManyToOne(optional = true)
	private PratoDestaque prato;
}

package br.senac.sp.guiarestaurante.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonPropertyOrder({ "status", "mensagem", "exception" })
public class Erro {
	private HttpStatus status;
	private String mensagem;
	private String exception;
}

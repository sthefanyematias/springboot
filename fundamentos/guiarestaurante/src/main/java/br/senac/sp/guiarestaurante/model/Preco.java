package br.senac.sp.guiarestaurante.model;

public enum Preco {
	BARATO("$"), MODERADO("$$"), CARO("$$$"), CARISSIMO("$$$$");

	String str;

	Preco(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}
}

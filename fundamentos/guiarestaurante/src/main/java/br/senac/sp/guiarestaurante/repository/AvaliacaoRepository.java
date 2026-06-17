package br.senac.sp.guiarestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.guiarestaurante.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

}

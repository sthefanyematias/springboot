package br.senac.sp.guiarestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.guiarestaurante.model.TipoPrato;

public interface TipoPratoRepository extends JpaRepository<TipoPrato, Long> {

}

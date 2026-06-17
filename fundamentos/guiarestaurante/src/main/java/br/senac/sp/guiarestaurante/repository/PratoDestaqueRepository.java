package br.senac.sp.guiarestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.guiarestaurante.model.PratoDestaque;

public interface PratoDestaqueRepository extends JpaRepository<PratoDestaque, Long> {

}

package br.senac.sp.guiarestaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.senac.sp.guiarestaurante.model.TipoRestaurante;

public interface TipoRestauranteRepository extends JpaRepository<TipoRestaurante, Long>{
	public TipoRestaurante findByNome(String nome);
	@Query("select tipo from TipoRestaurante tipo where tipo.descricao like %:p% order by tipo.nome asc")
	public List<TipoRestaurante> buscarTipos(@Param("p") String parametro);
	
}

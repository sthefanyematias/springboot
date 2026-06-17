package br.senac.sp.guiarestaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.sp.guiarestaurante.model.TipoRestaurante;
import br.senac.sp.guiarestaurante.repository.TipoRestauranteRepository;

@Service
public class TipoRestauranteService {	
	private final TipoRestauranteRepository repository;
	
	public TipoRestauranteService(TipoRestauranteRepository rep) {
		this.repository = rep;
	}
	
	public TipoRestaurante atualizar(Long id, TipoRestaurante tipo) {
		tipo.setId(id);
		return repository.save(tipo);
	}
	
	public void excluir(Long id) {
		TipoRestaurante tipo = buscarPorId(id);
		repository.delete(tipo);
	}
	
	public TipoRestaurante inserir(TipoRestaurante tipo) {
		return repository.save(tipo);
	}
	
	public TipoRestaurante buscarPorId(Long id) {
		Optional<TipoRestaurante> busca = repository.findById(id);
		if(busca.isPresent()) {
			return busca.get();
		}
		return null;
	}
	
	public Page<TipoRestaurante> listarTodos(Pageable pageable){
		return repository.findAll(pageable);
	}
}

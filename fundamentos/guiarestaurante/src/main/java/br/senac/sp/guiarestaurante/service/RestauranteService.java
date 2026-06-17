package br.senac.sp.guiarestaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.sp.guiarestaurante.model.Restaurante;
import br.senac.sp.guiarestaurante.repository.RestauranteRepository;

@Service
public class RestauranteService {	
	private final RestauranteRepository repository;
	
	public RestauranteService(RestauranteRepository rep) {
		this.repository = rep;
	}
	
	public Restaurante atualizar(Long id, Restaurante rest) {
		rest.setId(id);
		return repository.save(rest);
	}
	
	public void excluir(Long id) {
		Restaurante rest = buscarPorId(id);
		repository.delete(rest);
	}
	
	public Restaurante inserir(Restaurante rest) {
		return repository.save(rest);
	}
	
	public Restaurante buscarPorId(Long id) {
		Optional<Restaurante> busca = repository.findById(id);
		if(busca.isPresent()) {
			return busca.get();
		}
		return null;
	}
	
	public Page<Restaurante> listarTodos(Pageable pageable){
		return repository.findAll(pageable);
	}	
}

package br.senac.sp.guiarestaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.sp.guiarestaurante.model.TipoPrato;
import br.senac.sp.guiarestaurante.repository.TipoPratoRepository;

@Service
public class TipoPratoService {	
	private final TipoPratoRepository repository;
	
	public TipoPratoService(TipoPratoRepository rep) {
		this.repository = rep;
	}
	
	public TipoPrato atualizar(Long id, TipoPrato tipo) {
		tipo.setId(id);
		return repository.save(tipo);
	}
	
	public void excluir(Long id) {
		TipoPrato tipo = buscarPorId(id);
		repository.delete(tipo);
	}
	
	public TipoPrato inserir(TipoPrato tipo) {
		return repository.save(tipo);
	}
	
	public TipoPrato buscarPorId(Long id) {
		Optional<TipoPrato> busca = repository.findById(id);
		if(busca.isPresent()) {
			return busca.get();
		}
		return null;
	}
	
	public Page<TipoPrato> listarTodos(Pageable pageable){
		return repository.findAll(pageable);
	}
}

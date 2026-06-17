package br.senac.sp.guiarestaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.sp.guiarestaurante.model.Avaliacao;
import br.senac.sp.guiarestaurante.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {	
	private final AvaliacaoRepository repository;
	
	public AvaliacaoService(AvaliacaoRepository rep) {
		this.repository = rep;
	}
	
	public Avaliacao atualizar(Long id, Avaliacao avaliacao) {
		avaliacao.setId(id);
		return repository.save(avaliacao);
	}
	
	public void excluir(Long id) {
		Avaliacao avaliacao = buscarPorId(id);
		repository.delete(avaliacao);
	}
	
	public Avaliacao inserir(Avaliacao avaliacao) {
		return repository.save(avaliacao);
	}
	
	public Avaliacao buscarPorId(Long id) {
		Optional<Avaliacao> busca = repository.findById(id);
		if(busca.isPresent()) {
			return busca.get();
		}
		return null;
	}
	
	public Page<Avaliacao> listarTodos(Pageable pageable){
		return repository.findAll(pageable);
	}	
}

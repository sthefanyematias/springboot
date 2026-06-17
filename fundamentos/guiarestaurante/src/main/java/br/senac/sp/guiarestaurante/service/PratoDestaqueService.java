package br.senac.sp.guiarestaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.sp.guiarestaurante.model.PratoDestaque;
import br.senac.sp.guiarestaurante.repository.PratoDestaqueRepository;

@Service
public class PratoDestaqueService {	
	private final PratoDestaqueRepository repository;
	
	public PratoDestaqueService(PratoDestaqueRepository rep) {
		this.repository = rep;
	}
	
	public PratoDestaque atualizar(Long id, PratoDestaque prato) {
		prato.setId(id);
		return repository.save(prato);
	}
	
	public void excluir(Long id) {
		PratoDestaque prato = buscarPorId(id);
		repository.delete(prato);
	}
	
	public PratoDestaque inserir(PratoDestaque prato) {
		return repository.save(prato);
	}
	
	public PratoDestaque buscarPorId(Long id) {
		Optional<PratoDestaque> busca = repository.findById(id);
		if(busca.isPresent()) {
			return busca.get();
		}
		return null;
	}
	
	public Page<PratoDestaque> listarTodos(Pageable pageable){
		return repository.findAll(pageable);
	}
}

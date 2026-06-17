package br.senac.sp.guiarestaurante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.sp.guiarestaurante.model.Usuario;
import br.senac.sp.guiarestaurante.repository.UsuarioRepository;

@Service
public class UsuarioService {	
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository rep) {
		this.repository = rep;
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		usuario.setId(id);
		return repository.save(usuario);
	}
	
	public void excluir(Long id) {
		Usuario usuario = buscarPorId(id);
		repository.delete(usuario);
	}
	
	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> busca = repository.findById(id);
		if(busca.isPresent()) {
			return busca.get();
		}
		return null;
	}
	
	public Page<Usuario> listarTodos(Pageable pageable){
		return repository.findAll(pageable);
	}
}

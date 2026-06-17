package br.senac.sp.guiarestaurante.controller;

import java.net.URI;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.sp.guiarestaurante.model.Erro;
import br.senac.sp.guiarestaurante.model.Usuario;
import br.senac.sp.guiarestaurante.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private final  UsuarioService service;

	public UsuarioController(UsuarioService serv) {
		this.service = serv;
	}

	@GetMapping
	public ResponseEntity<Page<Usuario>> listar(
			@PageableDefault(page = 0, size = 10, sort = "nome", direction = Direction.ASC) 
			Pageable pageable) {
		Page<Usuario> page = service.listarTodos(pageable);
		if (page.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(page);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario){
		Usuario usuarioAtualizado = service.atualizar(id, usuario);
		return ResponseEntity.ok(usuarioAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody Usuario usuario) {
		try {
			Usuario salvo = service.inserir(usuario);
			return ResponseEntity.created(URI.create("/usuario/" + salvo.getId())).body(salvo);
		} catch (DataIntegrityViolationException e) {
			Erro erro = Erro.builder().status(HttpStatus.BAD_REQUEST).mensagem("Possível registro duplicado")
					.exception(e.getClass().getName()).build();
			return new ResponseEntity<Object>(erro, erro.getStatus());
		} catch (Exception e) {
			Erro erro = Erro.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).mensagem("Erro: " + e.getMessage())
					.exception(e.getClass().getName()).build();
			return new ResponseEntity<Object>(erro, erro.getStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable("id") Long id) {
		Usuario  usuario = service.buscarPorId(id);
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.notFound().build();
	}

}

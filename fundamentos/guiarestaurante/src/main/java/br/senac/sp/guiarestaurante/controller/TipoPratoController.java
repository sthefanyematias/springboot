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
import br.senac.sp.guiarestaurante.model.TipoPrato;
import br.senac.sp.guiarestaurante.service.TipoPratoService;

@RestController	
@RequestMapping("/tipoprato")
public class TipoPratoController {
	private final  TipoPratoService service;

	public TipoPratoController(TipoPratoService serv) {
		this.service = serv;
	}

	@GetMapping
	public ResponseEntity<Page<TipoPrato>> listar(
			@PageableDefault(page = 0, size = 10, sort = "nome", direction = Direction.ASC) 
			Pageable pageable) {
		Page<TipoPrato> page = service.listarTodos(pageable);
		if (page.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(page);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoPrato> atualizar(@PathVariable("id") Long id, @RequestBody TipoPrato tipo){
		TipoPrato tipoAtualizado = service.atualizar(id, tipo);
		return ResponseEntity.ok(tipoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody TipoPrato tipo) {
		try {
			TipoPrato salvo = service.inserir(tipo);
			return ResponseEntity.created(URI.create("/tipoprato/" + salvo.getId())).body(salvo);
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
	public ResponseEntity<TipoPrato> buscar(@PathVariable("id") Long id) {
		TipoPrato  tipo = service.buscarPorId(id);
		if (tipo != null) {
			return ResponseEntity.ok(tipo);
		}
		return ResponseEntity.notFound().build();
	}

}

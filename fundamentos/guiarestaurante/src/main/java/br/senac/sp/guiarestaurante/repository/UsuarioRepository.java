package br.senac.sp.guiarestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.guiarestaurante.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

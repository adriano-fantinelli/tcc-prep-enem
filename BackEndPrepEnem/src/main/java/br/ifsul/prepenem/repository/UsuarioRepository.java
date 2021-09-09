package br.ifsul.prepenem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.prepenem.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

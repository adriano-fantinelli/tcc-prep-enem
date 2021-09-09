package br.ifsul.prepenem.utils;


public class UsuarioNotFoundException extends RuntimeException {

	public UsuarioNotFoundException(Long id) {
		super("Usuário com o id " + id + " não encontrado.");
	}
}

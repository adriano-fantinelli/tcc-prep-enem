package br.ifsul.prepenem.utils;


public class RegistroNotFoundException extends RuntimeException {

	public RegistroNotFoundException(Long id) {
		super("Registro com o id " + id + " não encontrado.");
	}
}

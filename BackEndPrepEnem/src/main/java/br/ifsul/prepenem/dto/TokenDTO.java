package br.ifsul.prepenem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ifsul.prepenem.model.Questao;
import br.ifsul.prepenem.model.Usuario;

public class TokenDTO {
	private Long id;
	private String token;
	
	public TokenDTO() {
		super();
	}

	public TokenDTO(Long id, String token) {
		super();
		this.id = id;
		this.token = token;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}

package br.ifsul.prepenem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.ifsul.prepenem.model.Questao;
import br.ifsul.prepenem.model.Usuario;

public class ExplicacaoDTO {
	private Long id;
	private String textoExplicacao;
//	private Usuario usuario;
//	private Questao questao;

	public ExplicacaoDTO() {
		super();
	}

	public ExplicacaoDTO(Long id, String textoExplicacao, Usuario usuario, Questao questao) {
		super();
		this.id = id;
		this.textoExplicacao = textoExplicacao;
//		this.usuario = usuario;
//		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoExplicacao() {
		return textoExplicacao;
	}

	public void setTextoExplicacao(String textoExplicacao) {
		this.textoExplicacao = textoExplicacao;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//	public Questao getQuestao() {
//		return questao;
//	}
//
//	public void setQuestao(Questao questao) {
//		this.questao = questao;
//	}
}

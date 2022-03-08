package br.ifsul.prepenem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ifsul.prepenem.model.Questao;
import br.ifsul.prepenem.model.Usuario;

public class DesempenhoDTO {
	private Long id;
	private Boolean respondidaCorretamente;
//	private Usuario usuario;
//	private Questao questao;
	
	public DesempenhoDTO() {
	}

	public DesempenhoDTO(Long id, Boolean respondidaCorretamente, Usuario usuario, Questao questao) {
		super();
		this.id = id;
		this.respondidaCorretamente = respondidaCorretamente;
//		this.usuario = usuario;
//		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getRespondidaCorretamente() {
		return respondidaCorretamente;
	}

	public void setRespondidaCorretamente(Boolean respondidaCorretamente) {
		this.respondidaCorretamente = respondidaCorretamente;
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

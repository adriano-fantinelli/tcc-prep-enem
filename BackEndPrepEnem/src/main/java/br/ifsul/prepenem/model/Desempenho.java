package br.ifsul.prepenem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Desempenho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "desempenho_id")
	private Long id;
	private Boolean respondidaCorretamente;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name="questao_id")
	private Questao questao;
	
	public Desempenho() {
	}

	public Desempenho(Long id, Boolean respondidaCorretamente, Usuario usuario, Questao questao) {
		super();
		this.id = id;
		this.respondidaCorretamente = respondidaCorretamente;
		this.usuario = usuario;
		this.questao = questao;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
}

package br.ifsul.prepenem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Explicacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "explicacao_id")
	private Long id;
	
	private String textoExplicacao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "questao_id")
	private Questao questao;

	public Explicacao() {
		super();
	}

	public Explicacao(Long id, String textoExplicacao, Usuario usuario, Questao questao) {
		super();
		this.id = id;
		this.textoExplicacao = textoExplicacao;
		this.usuario = usuario;
		this.questao = questao;
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

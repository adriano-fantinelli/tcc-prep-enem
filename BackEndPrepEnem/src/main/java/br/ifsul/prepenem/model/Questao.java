package br.ifsul.prepenem.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questao_id")
	private Long id;
	
	@Column(length = 2000)
	private String enunciado, matrizCurricular, anoProva, imagem;
	
	@OneToOne(mappedBy="questao")
	private Explicacao explicacao;
	
	@OneToMany(mappedBy="questao")
	private Set<Alternativa> alternativa;
	
	@OneToMany(mappedBy="questao")
	private Set<Desempenho> desempenho;
	
	public Questao() {
		super();
	}

	public Questao(Long id, String enunciado, String matrizCurricular, String anoProva, String imagem,
			Explicacao explicacao, Set<Alternativa> alternativa, Set<Desempenho> desempenho) {
		super();
		this.id = id;
		this.enunciado = enunciado;
		this.matrizCurricular = matrizCurricular;
		this.anoProva = anoProva;
		this.imagem = imagem;
		this.explicacao = explicacao;
		this.alternativa = alternativa;
		this.desempenho = desempenho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getMatrizCurricular() {
		return matrizCurricular;
	}

	public void setMatrizCurricular(String matrizCurricular) {
		this.matrizCurricular = matrizCurricular;
	}

	public String getAnoProva() {
		return anoProva;
	}

	public void setAnoProva(String anoProva) {
		this.anoProva = anoProva;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Explicacao getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(Explicacao explicacao) {
		this.explicacao = explicacao;
	}

	public Set<Alternativa> getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Set<Alternativa> alternativa) {
		this.alternativa = alternativa;
	}

	public Set<Desempenho> getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Set<Desempenho> desempenho) {
		this.desempenho = desempenho;
	}
}
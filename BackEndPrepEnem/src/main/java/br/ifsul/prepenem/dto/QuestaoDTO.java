package br.ifsul.prepenem.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.ifsul.prepenem.model.Alternativa;
import br.ifsul.prepenem.model.Desempenho;
import br.ifsul.prepenem.model.Explicacao;

public class QuestaoDTO {
	private Long id;
	private String enunciado, matrizCurricular, anoProva, imagem;
	private ExplicacaoDTO explicacao;
	private Set<AlternativaDTO> alternativa;
	private Set<DesempenhoDTO> desempenho;
	
	public QuestaoDTO() {
		super();
	}

	public QuestaoDTO(Long id, String enunciado, String matrizCurricular, String anoProva, String imagem,
			ExplicacaoDTO explicacao, Set<AlternativaDTO> alternativa, Set<DesempenhoDTO> desempenho) {
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

	public ExplicacaoDTO getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(ExplicacaoDTO explicacao) {
		this.explicacao = explicacao;
	}

	public Set<AlternativaDTO> getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Set<AlternativaDTO> alternativa) {
		this.alternativa = alternativa;
	}

	public Set<DesempenhoDTO> getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Set<DesempenhoDTO> desempenho) {
		this.desempenho = desempenho;
	}
}
package br.ifsul.prepenem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ifsul.prepenem.model.Questao;

public class AlternativaDTO {
	private Long id;
	private boolean correta;
	private String textoAlternativa;
//	private Questao questao;
	
	public AlternativaDTO() {
		super();
	}

	public AlternativaDTO(Long id, boolean correta, String textoAlternativa, Questao questao) {
		super();
		this.id = id;
		this.correta = correta;
		this.textoAlternativa = textoAlternativa;
//		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}

	public String getTextoAlternativa() {
		return textoAlternativa;
	}

	public void setTextoAlternativa(String textoAlternativa) {
		this.textoAlternativa = textoAlternativa;
	}

//	public Questao getQuestao() {
//		return questao;
//	}
//
//	public void setQuestao(Questao questao) {
//		this.questao = questao;
//	}
}

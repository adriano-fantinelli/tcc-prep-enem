package br.ifsul.prepenem.dto;

public class AlternativaDTO {
	private Long id;
	private boolean correta;
	private String textoAlternativa;
	private QuestaoDTO questao;
	
	public AlternativaDTO() {
		super();
	}

	public AlternativaDTO(Long id, boolean correta, String textoAlternativa, QuestaoDTO questao) {
		super();
		this.id = id;
		this.correta = correta;
		this.textoAlternativa = textoAlternativa;
		this.questao = questao;
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

	public QuestaoDTO getQuestao() {
		return questao;
	}

	public void setQuestao(QuestaoDTO questao) {
		this.questao = questao;
	}
}

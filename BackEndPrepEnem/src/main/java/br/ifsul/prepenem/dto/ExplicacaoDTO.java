package br.ifsul.prepenem.dto;

public class ExplicacaoDTO {
	private Long id;
	private String textoExplicacao;
	//private UsuarioDTO usuario;
	private QuestaoDTO questao;

	public ExplicacaoDTO() {
		super();
	}

	public ExplicacaoDTO(Long id, String textoExplicacao, UsuarioDTO usuario, QuestaoDTO questao) {
		super();
		this.id = id;
		this.textoExplicacao = textoExplicacao;
//		this.usuario = usuario;
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

//	public UsuarioDTO getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(UsuarioDTO usuario) {
//		this.usuario = usuario;
//	}

	public QuestaoDTO getQuestao() {
		return questao;
	}

	public void setQuestao(QuestaoDTO questao) {
		this.questao = questao;
	}
}

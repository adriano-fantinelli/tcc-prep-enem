package br.ifsul.prepenem.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.ifsul.prepenem.model.Desempenho;
import br.ifsul.prepenem.model.Explicacao;

public class UsuarioDTO {
	private Long id;
	private String email, senha, nome, descricao, numeroCelular;
	private boolean professor;
	private Set<DesempenhoDTO> desempenho;
	private Set<ExplicacaoDTO> explicacao;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Long id, String email, String senha, String nome, String descricao, String numeroCelular,
			boolean professor, Set<DesempenhoDTO> desempenho, Set<ExplicacaoDTO> explicacao) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.descricao = descricao;
		this.numeroCelular = numeroCelular;
		this.professor = professor;
		this.desempenho = desempenho;
		this.explicacao = explicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public boolean isProfessor() {
		return professor;
	}

	public void setProfessor(boolean professor) {
		this.professor = professor;
	}

	public Set<DesempenhoDTO> getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Set<DesempenhoDTO> desempenho) {
		this.desempenho = desempenho;
	}

	public Set<ExplicacaoDTO> getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(Set<ExplicacaoDTO> explicacao) {
		this.explicacao = explicacao;
	}
}
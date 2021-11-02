package br.ifsul.prepenem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	private String email, senha, nome, descricao, numeroCelular;
	private boolean professor;

	@JsonManagedReference
	@OneToMany(mappedBy="usuario")
	private Set<Desempenho> desempenho;
	
	@JsonManagedReference
	@OneToMany(mappedBy="usuario")
	private Set<Explicacao> explicacao;
	
	public Usuario() {
	}

	Usuario(String email, String senha, String nome, String descricao, String numeroCelular, boolean professor) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.descricao = descricao;
		this.numeroCelular = numeroCelular;
		this.professor = professor;
	}
	
	public Set<Desempenho> getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Set<Desempenho> desempenho) {
		desempenho = desempenho;
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
}
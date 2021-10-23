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
	private String matrizCurricular;
	private int numeroRespondidas, numeroAcertos;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Desempenho() {
	}

	Desempenho(String matrizCurricular, int numeroRespondidas, int numeroAcertos, Usuario usuario) {
		this.matrizCurricular = matrizCurricular;
		this.numeroRespondidas = numeroRespondidas;
		this.numeroAcertos = numeroAcertos;
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatrizCurricular() {
		return matrizCurricular;
	}

	public void setMatrizCurricular(String matrizCurricular) {
		this.matrizCurricular = matrizCurricular;
	}

	public int getNumeroRespondidas() {
		return numeroRespondidas;
	}

	public void setNumeroRespondidas(int numeroRespondidas) {
		this.numeroRespondidas = numeroRespondidas;
	}

	public int getNumeroAcertos() {
		return numeroAcertos;
	}

	public void setNumeroAcertos(int numeroAcertos) {
		this.numeroAcertos = numeroAcertos;
	}
}

package br.ifsul.prepenem.dto;

public class DesempenhoDTO {
	private Long id;
	private String matrizCurricular;
	private int numeroRespondidas, numeroAcertos;
	//private UsuarioDTO usuario;

	public DesempenhoDTO() {
	}

	DesempenhoDTO(String matrizCurricular, int numeroRespondidas, int numeroAcertos, UsuarioDTO usuario) {
		this.matrizCurricular = matrizCurricular;
		this.numeroRespondidas = numeroRespondidas;
		this.numeroAcertos = numeroAcertos;
		//this.usuario = usuario;
	}
	
//	public UsuarioDTO getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(UsuarioDTO usuario) {
//		this.usuario = usuario;
//	}
//	
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

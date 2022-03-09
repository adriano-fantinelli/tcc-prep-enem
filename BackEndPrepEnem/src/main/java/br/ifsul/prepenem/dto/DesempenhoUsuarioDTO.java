package br.ifsul.prepenem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ifsul.prepenem.model.Questao;
import br.ifsul.prepenem.model.Usuario;

public class DesempenhoUsuarioDTO {
	private int totalRespondidas;
	private int totalRespondidasCorretamente;
	private int totalRespondidasIncorretamente;
	private double porcentagemDeAcerto;
	
	public DesempenhoUsuarioDTO() {
		super();
	}

	public DesempenhoUsuarioDTO(int totalRespondidas, int totalRespondidasCorretamente,
			int totalRespondidasIncorretamente, double porcentagemDeAcerto) {
		super();
		this.totalRespondidas = totalRespondidas;
		this.totalRespondidasCorretamente = totalRespondidasCorretamente;
		this.totalRespondidasIncorretamente = totalRespondidasIncorretamente;
		this.porcentagemDeAcerto = porcentagemDeAcerto;
	}
	
	public int getTotalRespondidas() {
		return totalRespondidas;
	}
	
	public void setTotalRespondidas(int totalRespondidas) {
		this.totalRespondidas = totalRespondidas;
	}
	
	public int getTotalRespondidasCorretamente() {
		return totalRespondidasCorretamente;
	}
	
	public void setTotalRespondidasCorretamente(int totalRespondidasCorretamente) {
		this.totalRespondidasCorretamente = totalRespondidasCorretamente;
	}
	
	public int getTotalRespondidasIncorretamente() {
		return totalRespondidasIncorretamente;
	}
	
	public void setTotalRespondidasIncorretamente(int totalRespondidasIncorretamente) {
		this.totalRespondidasIncorretamente = totalRespondidasIncorretamente;
	}
	
	public double getPorcentagemDeAcerto() {
		return porcentagemDeAcerto;
	}
	
	public void setPorcentagemDeAcerto(double porcentagemDeAcerto) {
		this.porcentagemDeAcerto = porcentagemDeAcerto;
	}
}

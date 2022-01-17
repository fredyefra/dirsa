package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nome_equipamento")
public class NomeEquipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private  Integer idNomeEquipamento;
	private  String  dsEquipamento;
	
	public NomeEquipamento() {
	}

	public NomeEquipamento(Integer idNomeEquipamento, String dsEquipamento) {
	
		this.idNomeEquipamento = idNomeEquipamento;
		this.dsEquipamento = dsEquipamento;
	}

	@Id
	@Column(name = "idNomeEquipamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	public Integer getIdNomeEquipamento() {
		return idNomeEquipamento;
	}

	public void setIdNomeEquipamento(Integer idNomeEquipamento) {
		this.idNomeEquipamento = idNomeEquipamento;
	}

	@Column(name ="dsEquipamento")
	public String getDsEquipamento() {
		return dsEquipamento;
	}

	public void setDsEquipamento(String dsEquipamento) {
		this.dsEquipamento = dsEquipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNomeEquipamento == null) ? 0 : idNomeEquipamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NomeEquipamento other = (NomeEquipamento) obj;
		if (idNomeEquipamento == null) {
			if (other.idNomeEquipamento != null)
				return false;
		} else if (!idNomeEquipamento.equals(other.idNomeEquipamento))
			return false;
		return true;
	}
}
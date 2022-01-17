package br.com.dirsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_equipamento")
public class TipoEquipamento {

	private Integer idTipoEquipamento;
	private String  dsTipoEquipamento;
	
	public TipoEquipamento() {
	
	}
	
	public TipoEquipamento(Integer idTipoEquipamento, String dsTipoEquipamento) {
		this.idTipoEquipamento = idTipoEquipamento;
		this.dsTipoEquipamento = dsTipoEquipamento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoEquipamento")
	public Integer getIdTipoEquipamento() {
		return idTipoEquipamento;
	}

	public void setIdTipoEquipamento(Integer idTipoEquipamento) {
		this.idTipoEquipamento = idTipoEquipamento;
	}

	@Column(name = "dsTipoEquipamento")
	public String getDsTipoEquipamento() {
		return dsTipoEquipamento;
	}

	public void setDsTipoEquipamento(String dsTipoEquipamento) {
		this.dsTipoEquipamento = dsTipoEquipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoEquipamento == null) ? 0 : idTipoEquipamento.hashCode());
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
		TipoEquipamento other = (TipoEquipamento) obj;
		if (idTipoEquipamento == null) {
			if (other.idTipoEquipamento != null)
				return false;
		} else if (!idTipoEquipamento.equals(other.idTipoEquipamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR TIPO EQUIPAMENTO **** " + idTipoEquipamento;
	}
}
package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_status_equipamento")
public class StatusEquipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idStatus;
	private String dsStatus;
	
	public StatusEquipamento() {
		
	}
	
	public StatusEquipamento(Integer idStatus, String dsStatus) {
		this.idStatus = idStatus;
		this.dsStatus = dsStatus;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStatus")
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	
	@Column(name = "dsStatus")
	public String getDsStatus() {
		return dsStatus;
	}
	public void setDsStatus(String dsStatus) {
		this.dsStatus = dsStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStatus == null) ? 0 : idStatus.hashCode());
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
		StatusEquipamento other = (StatusEquipamento) obj;
		if (idStatus == null) {
			if (other.idStatus != null)
				return false;
		} else if (!idStatus.equals(other.idStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR STATUS MODEL **** " + idStatus;
	}
}
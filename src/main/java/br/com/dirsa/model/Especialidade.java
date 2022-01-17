package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_especialidade")
public class Especialidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idEspecialidade;
	private String dsEspecialidade;
	
    public Especialidade() {
	}
    
    public Especialidade(Integer idEspecialidade, String dsEspecialidade) {
	    this.idEspecialidade = idEspecialidade;
		this.dsEspecialidade = dsEspecialidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEspecialidade")
	public Integer getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(Integer idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	@Column(name = "dsEspecialidade")
	public String getDsEspecialidade() {
		return dsEspecialidade;
	}

	public void setDsEspecialidade(String dsEspecialidade) {
		this.dsEspecialidade = dsEspecialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEspecialidade == null) ? 0 : idEspecialidade.hashCode());
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
		Especialidade other = (Especialidade) obj;
		if (idEspecialidade == null) {
			if (other.idEspecialidade != null)
				return false;
		} else if (!idEspecialidade.equals(other.idEspecialidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IdEspecialidade Medica **** " + idEspecialidade;
	}
}
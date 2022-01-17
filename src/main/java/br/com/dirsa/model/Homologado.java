package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_homologado")
public class Homologado implements Serializable {

	private static final long serialVersionUID = 1L;

	private  Integer idHomologado;
	private  String  dsHomologado;
	
    public Homologado() {
	}
	
    public Homologado(Integer idHomologado) {
		this.idHomologado = idHomologado;
	}
    
	public Homologado(Integer idHomologado, String dsHomologado) {
		this.idHomologado = idHomologado;
		this.dsHomologado = dsHomologado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHomologado")
	public Integer getIdHomologado() {
		return idHomologado;
	}

	public void setIdHomologado(Integer idHomologado) {
		this.idHomologado = idHomologado;
	}

	@Column(name = "dsHomologado")
	public String getDsHomologado() {
		return dsHomologado;
	}

	public void setDsHomologado(String dsHomologado) {
		this.dsHomologado = dsHomologado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHomologado == null) ? 0 : idHomologado.hashCode());
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
		Homologado other = (Homologado) obj;
		if (idHomologado == null) {
			if (other.idHomologado != null)
				return false;
		} else if (!idHomologado.equals(other.idHomologado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR HOMOLOGADO MODEL **** " + idHomologado;
	}
}
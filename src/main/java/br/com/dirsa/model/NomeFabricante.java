package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nome_fabricante")
public class NomeFabricante implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idFabricante;
	private String dsFabricante;
	 
	public NomeFabricante() {
	
	}

	public NomeFabricante(Integer idFabricante, String dsFabricante) {
		this.idFabricante = idFabricante;
		this.dsFabricante = dsFabricante;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFabricante")
	public Integer getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}
    
	@Column(name = "dsFabricante")
	public String getDsFabricante() {
		return dsFabricante;
	}

	public void setDsFabricante(String dsFabricante) {
		this.dsFabricante = dsFabricante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFabricante == null) ? 0 : idFabricante.hashCode());
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
		NomeFabricante other = (NomeFabricante) obj;
		if (idFabricante == null) {
			if (other.idFabricante != null)
				return false;
		} else if (!idFabricante.equals(other.idFabricante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR FABRICANTE MODEL **** " + idFabricante;
	}
}
package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_osa")
public class OrganizacaoSaudeAeronautica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idOsa;
	private String dsOsa;
    private String dsEscalao;
	private Perfil perfil;
	
	public OrganizacaoSaudeAeronautica() {
	}

	public OrganizacaoSaudeAeronautica(Integer idOsa, String dsOsa, String dsEscalao, Perfil perfil) {
		this.idOsa = idOsa;
		this.dsOsa = dsOsa;
		this.dsEscalao = dsEscalao;
		this.perfil = perfil;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOsa")
	public Integer getIdOsa() {
		return idOsa;
	}
	public void setIdOsa(Integer idOsa) {
		this.idOsa = idOsa;
	}
	
	@Column(name = "dsOsa")
	public String getDsOsa() {
		return dsOsa;
	}
	public void setDsOsa(String dsOsa) {
		this.dsOsa = dsOsa;
	}
	
	@Column(name = "dsEscalao")
	public String getDsEscalao() {
		return dsEscalao;
	}
	public void setDsEscalao(String dsEscalao) {
		this.dsEscalao = dsEscalao;
	}
	
	@ManyToOne
	@JoinColumn(name = "fkPerfil")
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOsa == null) ? 0 : idOsa.hashCode());
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
		OrganizacaoSaudeAeronautica other = (OrganizacaoSaudeAeronautica) obj;
		if (idOsa == null) {
			if (other.idOsa != null)
				return false;
		} else if (!idOsa.equals(other.idOsa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "----- ID Organizacao de Saude ----- " + this.idOsa;
	}
	
}
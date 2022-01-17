package br.com.dirsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_posto_graduacao")
public class PostoGraduacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idPostoGraduacao;
	private String dsPostoGraduacao;
	
	public PostoGraduacao() {
	
	}

	public PostoGraduacao(Integer idPostoGraduacao, String dsPostoGraduacao) {
		this.idPostoGraduacao = idPostoGraduacao;
		this.dsPostoGraduacao = dsPostoGraduacao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPostoGraduacao")
	public Integer getIdPostoGraduacao() {
		return idPostoGraduacao;
	}

	public void setIdPostoGraduacao(Integer idPostoGraduacao) {
		this.idPostoGraduacao = idPostoGraduacao;
	}
    
	@Column(name = "dsPostoGraduacao")
	public String getDsPostoGraduacao() {
		return dsPostoGraduacao;
	}

	public void setDsPostoGraduacao(String dsPostoGraduacao) {
		this.dsPostoGraduacao = dsPostoGraduacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPostoGraduacao == null) ? 0 : idPostoGraduacao.hashCode());
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
		PostoGraduacao other = (PostoGraduacao) obj;
		if (idPostoGraduacao == null) {
			if (other.idPostoGraduacao != null)
				return false;
		} else if (!idPostoGraduacao.equals(other.idPostoGraduacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR POSTO/GRADUACAO MODEL **** " + idPostoGraduacao;
	}
	
}
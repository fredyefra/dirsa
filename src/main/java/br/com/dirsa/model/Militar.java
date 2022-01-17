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

//@Entity
//@Table(name = "tb_militar")
public class Militar implements Serializable {

	/*private static final long serialVersionUID = 1L;

	private Integer idMilitar;
	private String nomeCompleto;
	private String nomeGuerra;
    private Long saram;
	private String email;
    
    Chaves Estrangeira
    private PostoGraduacao postoGraduacao; 
	private OrganizacaoSaudeAeronautica organizacaoSaudeAeronautica;
    
    public Militar() {
	}
    
    public Militar(Integer idMilitar, String nomeCompleto, String nomeGuerra, Long saram, String email,
			PostoGraduacao postoGraduacao, OrganizacaoSaudeAeronautica organizacaoSaudeAeronautica) {
		this.idMilitar = idMilitar;
		this.nomeCompleto = nomeCompleto;
		this.nomeGuerra = nomeGuerra;
		this.saram = saram;
		this.email = email;
		this.postoGraduacao = postoGraduacao;
		this.organizacaoSaudeAeronautica = organizacaoSaudeAeronautica;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMilitar")
	public Integer getIdMilitar() {
		return idMilitar;
	}

	public void setIdMilitar(Integer idMilitar) {
		this.idMilitar = idMilitar;
	}

	@Column(name = "nomeCompleto")
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
    
	@Column(name = "nomeGuerra")
	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	@Column(name = "saram")
	public Long getSaram() {
		return saram;
	}

	public void setSaram(Long saram) {
		this.saram = saram;
	}
    
	@Column(name = "email") 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name = "fkPostoGraduacao")
	public PostoGraduacao getPostoGraduacao() {
		return postoGraduacao;
	}

	public void setPostoGraduacao(PostoGraduacao postoGraduacao) {
		this.postoGraduacao = postoGraduacao;
	}
     
	@ManyToOne
	@JoinColumn(name = "fkOsa")
	public OrganizacaoSaudeAeronautica getOrganizacaoSaudeAeronautica() {
		return organizacaoSaudeAeronautica;
	}

	public void setOrganizacaoSaudeAeronautica(OrganizacaoSaudeAeronautica organizacaoSaudeAeronautica) {
		this.organizacaoSaudeAeronautica = organizacaoSaudeAeronautica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMilitar == null) ? 0 : idMilitar.hashCode());
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
		Militar other = (Militar) obj;
		if (idMilitar == null) {
			if (other.idMilitar != null)
				return false;
		} else if (!idMilitar.equals(other.idMilitar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR MILITAR MODEL **** " + idMilitar;
	}*/
}
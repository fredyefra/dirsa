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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	private Long saram;
	private String senha;
    private String nomeCompleto;
	private String nomeGuerra;
    private String email;
    
    //private Militar militar;
    private PostoGraduacao postoGraduacao; 
	private OrganizacaoSaudeAeronautica organizacaoSaudeAeronautica;
	private Perfil perfil;
	
	public Usuario() {
	}

    public Usuario(Integer idUsuario, Long saram, String senha, String nomeCompleto, String nomeGuerra, String email,
			PostoGraduacao postoGraduacao, OrganizacaoSaudeAeronautica organizacaoSaudeAeronautica, Perfil perfil) {
		this.idUsuario = idUsuario;
		this.saram = saram;
		this.senha = senha;
		this.nomeCompleto = nomeCompleto;
		this.nomeGuerra = nomeGuerra;
		this.email = email;
		this.postoGraduacao = postoGraduacao;
		this.organizacaoSaudeAeronautica = organizacaoSaudeAeronautica;
		this.perfil = perfil;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "saram")
	@Digits(fraction = 0, integer = 15, message ="Somente Números")
	public Long getSaram() {
		return saram;
	}

	public void setSaram(Long saram) {
		this.saram = saram;
	}

	@Column(name = "senha", nullable = false)
	@NotNull(message = "Campo Obrigatório")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
	@Column(name = "email") 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne
	@JoinColumn(name = "fkPerfil")
	public Perfil getPerfil() {
		return perfil;
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
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/*@ManyToOne
    @JoinColumn(name = "fkMilitar")
	public Militar getMilitar() {
		return militar;
	}

	public void setMilitar(Militar militar) {
		this.militar = militar;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR USUARIO MODEL **** " + idUsuario;
	}
}
package br.com.dirsa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity   
@Table(name = "tb_movimentacao")
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idMovimentacao;
	private Date dtEnvio;
	
	//Chaves Estrangeiras
	private OrganizacaoSaudeAeronautica organizacaoOrigem;
	private OrganizacaoSaudeAeronautica organizacaoAtual;
	private Equipamento equipamento;
	private Usuario usuario;
	
	public Movimentacao() {
	}

	public Movimentacao(Integer idMovimentacao, Date dtEnvio,
			OrganizacaoSaudeAeronautica organizacaoOrigem, OrganizacaoSaudeAeronautica organizacaoAtual,
			Equipamento equipamento, Usuario usuario) {
		this.idMovimentacao = idMovimentacao;
		this.dtEnvio = dtEnvio;
		this.organizacaoOrigem = organizacaoOrigem;
		this.organizacaoAtual = organizacaoAtual;
		this.equipamento = equipamento;
		this.usuario = usuario;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMovimentacao")
	public Integer getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Integer idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	@Column(name = "dtEnvio")
	public Date getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	@ManyToOne
	@JoinColumn(name = "fkOsaOrigem")
	public OrganizacaoSaudeAeronautica getOrganizacaoOrigem() {
		return organizacaoOrigem;
	}

	public void setOrganizacaoOrigem(OrganizacaoSaudeAeronautica organizacaoOrigem) {
		this.organizacaoOrigem = organizacaoOrigem;
	}

	@ManyToOne
	@JoinColumn(name = "fkOsaAtual")
	public OrganizacaoSaudeAeronautica getOrganizacaoAtual() {
		return organizacaoAtual;
	}

	public void setOrganizacaoAtual(OrganizacaoSaudeAeronautica organizacaoAtual) {
		this.organizacaoAtual = organizacaoAtual;
	}

	@ManyToOne
	@JoinColumn(name = "fkEquipamento")
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@ManyToOne
	@JoinColumn(name = "fkUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMovimentacao == null) ? 0 : idMovimentacao.hashCode());
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
		Movimentacao other = (Movimentacao) obj;
		if (idMovimentacao == null) {
			if (other.idMovimentacao != null)
				return false;
		} else if (!idMovimentacao.equals(other.idMovimentacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IdMovimentacao **** " + idMovimentacao;
	}
}
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
@Table(name = "tb_solicitacao_equipamento")
public class SolicitacaoEquipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idSolicitacao;
	private Integer quantidade;
	private Long valorEstimado;
    /*private Boolean homologado = false;*/
	
	/*Chaves Estrangeiras*/
	private NomeEquipamento nomeEquipamento; 
	private NomeFabricante nomeFabricante;
	private Homologado homologado;
	private Usuario usuario;
	
	public SolicitacaoEquipamento(){
	}

	public SolicitacaoEquipamento(Integer idSolicitacao, Integer quantidade, Long valorEstimado,
			NomeEquipamento nomeEquipamento, NomeFabricante nomeFabricante, Homologado homologado, Militar militar) {
		this.idSolicitacao = idSolicitacao;
		this.quantidade = quantidade;
		this.valorEstimado = valorEstimado;
		this.nomeEquipamento = nomeEquipamento;
		this.nomeFabricante = nomeFabricante;
		this.homologado = homologado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSolicitacao")
	public Integer getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(Integer idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(Long valorEstimado) {
		this.valorEstimado = valorEstimado;
	}
	
	@ManyToOne
	@JoinColumn(name = "fkNomeEquipamento")
	public NomeEquipamento getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(NomeEquipamento nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	@ManyToOne
	@JoinColumn(name = "fkNomeFabricante")
	public NomeFabricante getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(NomeFabricante nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	@ManyToOne
	@JoinColumn(name = "fkHomologado") 
	public Homologado getHomologado() {
		return homologado;
	}

	public void setHomologado(Homologado homologado) {
		this.homologado = homologado;
	}

	/*@Column(name = "isHomologado", nullable = false, updatable = true)
	public Boolean getHomologado() {
		return homologado;
	}

	public void setHomologado(Boolean homologado) {
		this.homologado = homologado;
	}
    */
    
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
		result = prime * result + ((idSolicitacao == null) ? 0 : idSolicitacao.hashCode());
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
		SolicitacaoEquipamento other = (SolicitacaoEquipamento) obj;
		if (idSolicitacao == null) {
			if (other.idSolicitacao != null)
				return false;
		} else if (!idSolicitacao.equals(other.idSolicitacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR SOLICITAÇÃO MODEL **** " + idSolicitacao;
	}
}
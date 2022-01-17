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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "tb_equipamento")
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idEquipamento;
	private Long numeroSerie;
	private String numeroPatrimonio;
	private Long custoAnualManutencao;
	private Integer quantidade;
	private Date dtInicioOperacao;
	private Date dtFinalVidaUtil;
	private Boolean movimentado = false;
	
	/** Chaves Estrangeiras */
	private OrganizacaoSaudeAeronautica organizacaoOrigem; 
	private OrganizacaoSaudeAeronautica organizacaoAtual;
	private Especialidade especialidade;
	private TipoEquipamento tipoEquipamento;
	private NomeEquipamento nomeEquipamento;
	private NomeFabricante nomeFabricante;
	private StatusEquipamento statusEquipamento;
	private Usuario usuario;
	
	public Equipamento() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEquipamento")
	public Integer getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(Integer idEquipamento) {
		this.idEquipamento = idEquipamento;
	}
    
    @Column(name = "numeroSerie")
    @Digits(fraction = 0, integer = 15, message ="Somente Números")
    public Long getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	@Column(name = "numeroPatrimonio")
	public String getNumeroPatrimonio() {
		return numeroPatrimonio;
	}

	public void setNumeroPatrimonio(String numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "custoAnualManutencao")
	public Long getCustoAnualManutencao() {
		return custoAnualManutencao;
	}

	public void setCustoAnualManutencao(Long custoAnualManutencao) {
		this.custoAnualManutencao = custoAnualManutencao;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dtInicioOperacao")
	//@Past(message ="Data Inválida - PASSADO")
	//@Future(message="Data Inválida")
	public Date getDtInicioOperacao() {
		return dtInicioOperacao;
	}

	public void setDtInicioOperacao(Date dtInicioOperacao) {
		this.dtInicioOperacao = dtInicioOperacao;
	}
    
	@Temporal(TemporalType.DATE)
	@Column(name = "dtFinalVidaUtil")
	public Date getDtFinalVidaUtil() {
		return dtFinalVidaUtil;
	}

	public void setDtFinalVidaUtil(Date dtFinalVidaUtil) {
		this.dtFinalVidaUtil = dtFinalVidaUtil;
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
	@JoinColumn(name = "fkEspecialidade")
	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
        
	@ManyToOne
	@JoinColumn(name = "fkTipoEquipamento")
	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
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
	@JoinColumn(name = "fkStatusEquipamento")
	public StatusEquipamento getStatusEquipamento() {
		return statusEquipamento;
	}

	public void setStatusEquipamento(StatusEquipamento statusEquipamento) {
		this.statusEquipamento = statusEquipamento;
	}

	@ManyToOne
	@JoinColumn(name = "fkUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "movimentado", nullable = false, updatable = true)
	public Boolean getMovimentado() {
		return movimentado;
	}

	public void setMovimentado(Boolean movimentado) {
		this.movimentado = movimentado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEquipamento == null) ? 0 : idEquipamento.hashCode());
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
		Equipamento other = (Equipamento) obj;
		if (idEquipamento == null) {
			if (other.idEquipamento != null)
				return false;
		} else if (!idEquipamento.equals(other.idEquipamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR EQUIPAMENTO MODEL **** " + idEquipamento;
	}
}
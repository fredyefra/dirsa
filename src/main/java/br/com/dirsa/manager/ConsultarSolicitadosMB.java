package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.dirsa.model.Homologado;
import br.com.dirsa.model.NomeEquipamento;
import br.com.dirsa.model.NomeFabricante;
import br.com.dirsa.model.SolicitacaoEquipamento;
import br.com.dirsa.service.bean.IComboBoxService;
import br.com.dirsa.service.bean.IConsultarSolicitadosService;
import br.com.dirsa.util.MessageMB;

@Stateful
@RequestScoped
@Named(value = "consultarSolicitadosMB")
public class ConsultarSolicitadosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IComboBoxService comboBoxService;
	@Inject
	private SolicitacaoEquipamento solicitado;
	@Inject
	private IConsultarSolicitadosService service;
    @Inject
    private NomeEquipamento nomeEquipamento;
    @Inject
    private NomeFabricante nomeFabricante;
    @Inject
    private MessageMB messageMB;
    
    private List<SolicitacaoEquipamento> solicitarEquipamentos;
    private List<NomeEquipamento> nomeEquipamentos;
    private List<NomeFabricante> nomeFabricantes;
    private List<Homologado> homologados;
    
    @PostConstruct
    public void carregar() {
		solicitarEquipamentos = service.buscarSolicitados();
	    nomeEquipamentos = comboBoxService.buscarNomeEquipamentos();
        nomeFabricantes = comboBoxService.buscarFabricantes();
        homologados = comboBoxService.buscarHomologados();
    }

    /*public void carregarDetalhamento(Equipamento equipamento) {
		this.solicitado = service.carregarSolicitacao(solicitado.getIdSolicitacao());
	    
		service.atualizar(solicitado);
    
    }*/
    
    public void onRowEdit(RowEditEvent event) {
      
    	SolicitacaoEquipamento solicitacaoEquipamento = (SolicitacaoEquipamento) event.getObject();
    
    	service.atualizar(solicitacaoEquipamento);
    	
    	messageMB.info("Solicitação alterada com sucesso!");
    
    	return;
    }

	public SolicitacaoEquipamento getSolicitado() {
		return solicitado;
	}

	public void setSolicitado(SolicitacaoEquipamento solicitado) {
		this.solicitado = solicitado;
	}

	public List<SolicitacaoEquipamento> getSolicitarEquipamentos() {
		return solicitarEquipamentos;
	}

	public void setSolicitarEquipamentos(List<SolicitacaoEquipamento> solicitarEquipamentos) {
		this.solicitarEquipamentos = solicitarEquipamentos;
	}

	public NomeEquipamento getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(NomeEquipamento nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	public List<NomeEquipamento> getNomeEquipamentos() {
		return nomeEquipamentos;
	}

	public void setNomeEquipamentos(List<NomeEquipamento> nomeEquipamentos) {
		this.nomeEquipamentos = nomeEquipamentos;
	}

	public List<NomeFabricante> getNomeFabricantes() {
		return nomeFabricantes;
	}

	public void setNomeFabricantes(List<NomeFabricante> nomeFabricantes) {
		this.nomeFabricantes = nomeFabricantes;
	}

	public NomeFabricante getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(NomeFabricante nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public List<Homologado> getHomologados() {
		return homologados;
	}

	public void setHomologados(List<Homologado> homologados) {
		this.homologados = homologados;
	}
}
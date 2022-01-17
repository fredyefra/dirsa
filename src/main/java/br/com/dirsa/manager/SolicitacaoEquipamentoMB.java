package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dirsa.model.NomeEquipamento;
import br.com.dirsa.model.NomeFabricante;
import br.com.dirsa.model.SolicitacaoEquipamento;
import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.IComboBoxService;
import br.com.dirsa.service.bean.ISolicitarEquipamentoService;
import br.com.dirsa.util.MessageMB;

@Stateful
@RequestScoped
@Named(value = "solicitacaoEquipamentoMB")
public class SolicitacaoEquipamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;
    @Inject
	private ISolicitarEquipamentoService service;
	@Inject
	private SolicitacaoEquipamento solicitacaoEquipamento;
    @Inject
	private IComboBoxService comboBoxService;
	@Inject
	private MessageMB messageMB;
	@Inject
	private LoginMB loginMB;
	
    private List<NomeEquipamento> nomeEquipamentos;
	private List<NomeFabricante> nomeFabricantes;
    
    @PostConstruct
    public void carregar() {
		nomeEquipamentos = comboBoxService.buscarNomeEquipamentos();
        nomeFabricantes = comboBoxService.buscarFabricantes();
    }
    
    public void salvar() {
		
    	Usuario usuario = loginMB.getUsuario();
    	
    	solicitacaoEquipamento.setUsuario(usuario);
    	service.salvar(solicitacaoEquipamento);
		messageMB.info("Solicitação enviada para análise da DIRSA.");
		reiniciar();
	}
	
	private void reiniciar(){
		solicitacaoEquipamento = new SolicitacaoEquipamento();
	}
	
	public SolicitacaoEquipamento getSolicitacaoEquipamento() {
		return solicitacaoEquipamento;
	}

	public void setSolicitacaoEquipamento(SolicitacaoEquipamento solicitacaoEquipamento) {
		this.solicitacaoEquipamento = solicitacaoEquipamento;
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

	public LoginMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}
}
package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dirsa.model.Equipamento;
import br.com.dirsa.model.Especialidade;
import br.com.dirsa.model.Militar;
import br.com.dirsa.model.NomeEquipamento;
import br.com.dirsa.model.NomeFabricante;
import br.com.dirsa.model.OrganizacaoSaudeAeronautica;
import br.com.dirsa.model.StatusEquipamento;
import br.com.dirsa.model.TipoEquipamento;
import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.IComboBoxService;
import br.com.dirsa.service.bean.IEquipamentoService;
import br.com.dirsa.util.MessageMB;

@Stateful
@RequestScoped
@Named(value = "materialCargaMB")
public class MaterialCargaMB implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Inject
	private IEquipamentoService service;
	@Inject
	private IComboBoxService comboBoxService;
	@Inject
	private Equipamento equipamento;
	@Inject
	private LoginMB loginMB;
	@Inject
	private MessageMB messageMB;

	private List<OrganizacaoSaudeAeronautica> osasOrigem;
	private List<OrganizacaoSaudeAeronautica> osasAtual;
	private List<Especialidade> especialidades;
	private List<TipoEquipamento> tipoEquipamentos;
	private List<NomeEquipamento> nomeEquipamentos;
	private List<NomeFabricante> nomeFabricantes;
    private List<StatusEquipamento> statusEquipamentos;
	
    @PostConstruct
	public void carregar() {
		osasOrigem = comboBoxService.buscarOsas();
		osasAtual = comboBoxService.buscarOsas();
		especialidades = comboBoxService.buscarEspecialidades();
		tipoEquipamentos = comboBoxService.buscarTipoEquipamentos();
		nomeEquipamentos = comboBoxService.buscarNomeEquipamentos();
		nomeFabricantes = comboBoxService.buscarFabricantes();
	    statusEquipamentos = comboBoxService.buscarStatusEquipamentos();
    }

	public String salvar() {

		List<String> patrimonio = service.verificarPatrimonio();

		if (patrimonio.contains(equipamento.getNumeroPatrimonio())) {
			messageMB.error("Número de Patrimonio já existe!");
			
			return null;
		}
        
		Usuario usuario = loginMB.getUsuario();
		equipamento.setUsuario(usuario);
		service.salvar(equipamento);

		if (!equipamento.equals(null)) {
			messageMB.info("Material Carga Salvo!");
			reiniciar();
			return "sucess";
		}

		return null;
	}

	private void reiniciar(){
		equipamento = new Equipamento();
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<OrganizacaoSaudeAeronautica> getOsasOrigem() {
		return osasOrigem;
	}

	public void setOsasOrigem(List<OrganizacaoSaudeAeronautica> osasOrigem) {
		this.osasOrigem = osasOrigem;
	}

	public List<OrganizacaoSaudeAeronautica> getOsasAtual() {
		return osasAtual;
	}

	public void setOsasAtual(List<OrganizacaoSaudeAeronautica> osasAtual) {
		this.osasAtual = osasAtual;
	}

	public List<TipoEquipamento> getTipoEquipamentos() {
		return tipoEquipamentos;
	}

	public void setTipoEquipamentos(List<TipoEquipamento> tipoEquipamentos) {
		this.tipoEquipamentos = tipoEquipamentos;
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

	public List<StatusEquipamento> getStatusEquipamentos() {
		return statusEquipamentos;
	}

	public void setStatusEquipamentos(List<StatusEquipamento> statusEquipamentos) {
		this.statusEquipamentos = statusEquipamentos;
	}
}
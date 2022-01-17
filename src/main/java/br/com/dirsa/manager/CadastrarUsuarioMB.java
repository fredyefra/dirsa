package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dirsa.model.Equipamento;
import br.com.dirsa.model.Militar;
import br.com.dirsa.model.OrganizacaoSaudeAeronautica;
import br.com.dirsa.model.Perfil;
import br.com.dirsa.model.PostoGraduacao;
import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.ICadastrarUsuarioService;
import br.com.dirsa.service.bean.IComboBoxService;
import br.com.dirsa.util.CalcularHashBean;
import br.com.dirsa.util.MessageMB;

@Stateful
@ViewScoped
@Named(value = "cadastrarUsuarioMB")
public class CadastrarUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IComboBoxService comboBoxService;
    @Inject
	private ICadastrarUsuarioService cadastrarUsuarioService;
	@Inject
	private Militar militar;
	@Inject
	private Usuario usuario;
	@Inject
	private MessageMB messageMB;
	@Inject
	private Equipamento equipamento; 
	
	private List<Perfil> perfis;
	private List<PostoGraduacao> postosGraduacoes;
	private List<OrganizacaoSaudeAeronautica> osas;
	
	@PostConstruct
	public void carregar() {
		postosGraduacoes = comboBoxService.buscarPostosGraduacoes();
        perfis = comboBoxService.buscarPerfis();
	}
    
	public Militar getMilitar() {
		return militar;
	}

    public void setMilitar(Militar militar) {
		this.militar = militar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<PostoGraduacao> getPostosGraduacoes() {
		return postosGraduacoes;
	}

	public void setPostosGraduacoes(List<PostoGraduacao> postosGraduacoes) {
		this.postosGraduacoes = postosGraduacoes;
	}
	
	public List<OrganizacaoSaudeAeronautica> getOsas() {
		return osas;
	}

	public void setOsas(List<OrganizacaoSaudeAeronautica> osas) {
		this.osas = osas;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	//Implementar EVENTO de COMBOS dependentes
	public void buscarOsaPorPerfil() {
		osas = comboBoxService.buscarOsaPorPerfil(usuario.getPerfil().getIdPerfil());
	}
	
    public void salvar() {
		
    	List<String> saram = cadastrarUsuarioService.verificarSaram();
    	
		if (saram.contains(usuario.getSaram())) {
			messageMB.error("Número de Saram já existe!");
			return;
		}
    	
    	usuario.setSenha(CalcularHashBean.sha256("sices@17"));
    	cadastrarUsuarioService.salvar(usuario);
    	messageMB.info("Usuário Salvo!");
    	
    	reiniciar();
    	
       return;
    }

	private void reiniciar(){
		usuario = new Usuario();
	}
}
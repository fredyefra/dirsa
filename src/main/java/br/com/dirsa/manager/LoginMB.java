package br.com.dirsa.manager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;

import br.com.dirsa.model.Usuario;
import br.com.dirsa.util.MessageMB;
import br.com.dirsa.util.UserGeneric;

//@ViewScoped
@SessionScoped
@Named("loginMB")
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private MessageMB messageMB;
	@Inject
	private Identity identidade;
	@Inject
	private UserGeneric user;
    
	private Usuario usuario;
	private String postoGraduacao;
	private String nomeGuerra;
	private String perfil;
	private String unidadeMilitar;

	public String login() {

		AuthenticationResult result = identidade.login();

		if (AuthenticationResult.FAILED.equals(result)) {
			messageMB.error("Usu�rio ou Senha Incorretos!");
		}
		return "sucess";
	}

	public String logOut() {
		identidade.logout();
		return "logoff";
	}

	public String changePass(){
		return "change";
	}
	
	public Identity getIdentidade() {
		return identidade;
	}

	public void setIdentidade(Identity identidade) {
		this.identidade = identidade;
	}

    public UserGeneric getUser() {
		return user;
	}

	public void setUser(UserGeneric user) {
		this.user = user;
	}

	public String getPostoGraduacao() {
			return postoGraduacao = ((((UserGeneric) identidade.getAccount()).getFirstName()));
	}

	public void setPostoGraduacao(String postoGraduacao) {
		if (identidade != null || identidade.getAccount() != null) {
			this.postoGraduacao = postoGraduacao;
		}
	}
	
	public String getNomeGuerra() {
		return nomeGuerra = (((UserGeneric) identidade.getAccount()).getLastName()); 
	}

	public void setNomeGuerra(String nomeGuerra) {
		if (identidade != null || identidade.getAccount() != null) {
			this.nomeGuerra = nomeGuerra;
		}
	}
	
	public String getPerfil() {
		return perfil = (((UserGeneric) identidade.getAccount()).getLoginName());
	}

	public void setPerfil(String perfil) {
		if (identidade != null || identidade.getAccount() != null) {
			this.perfil = perfil;
		}
	}
	
	public String getUnidadeMilitar() {
		return unidadeMilitar = (((UserGeneric) identidade.getAccount()).getEmail());
	}

	public void setUnidadeMilitar(String unidadeMilitar) {
		if (identidade != null || identidade.getAccount() != null) {
			this.unidadeMilitar = unidadeMilitar;
		}
	}	
	
	public Usuario getUsuario() {
		return usuario = ((UserGeneric) identidade.getAccount()).getUsuario();
	}

	public void setUsuario(Usuario usuario) {
		if (identidade != null || identidade.getAccount() != null) {
			this.usuario = usuario;
		}
	}

}
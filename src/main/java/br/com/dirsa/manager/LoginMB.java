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
			messageMB.error("Usuário ou Senha Incorretos!");
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

		if (identidade != null || identidade.getAccount() != null) {
			return postoGraduacao = (((UserGeneric) identidade.getAccount()).getFirstName());
		}
		return null;
	}

	public String getNomeGuerra() {

		if (identidade != null || identidade.getAccount() != null) {
			return nomeGuerra = (((UserGeneric) identidade.getAccount()).getLastName());
		}
		return null;
	}

	public String getPerfil() {

		if (identidade != null || identidade.getAccount() != null) {
			return perfil = (((UserGeneric) identidade.getAccount()).getLoginName());
		}
		return null;
	}

	public String getUnidadeMilitar() {

		if (identidade != null || identidade.getAccount() != null) {
			return perfil = (((UserGeneric) identidade.getAccount()).getEmail());
		}
		return null;
	}

	public Usuario getUsuario() {
	
		if (identidade != null || identidade.getAccount() != null) {
			return usuario = (((UserGeneric) identidade.getAccount()).getUsuario());
		}
		return null;
	}
}
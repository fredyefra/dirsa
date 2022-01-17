package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.IAlterarSenhaService;
import br.com.dirsa.util.CalcularHashBean;
import br.com.dirsa.util.MessageMB;

@ViewScoped
@Named("alterarSenhaMB")
public class AlterarSenhaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IAlterarSenhaService alterarSenhaService;
	@Inject
	private Usuario usuario;
	@Inject
	private MessageMB messageMB;
	@Inject
	private LoginMB loginMB;

	public AlterarSenhaMB() {
	}

	private String senha;
	private String senha2;
	private String novaSenha;

	public String pesquisar() {

		List<Usuario> usuarios = alterarSenhaService.consultarUsuario(senha);

		if(!senha.equals(senha2)){  

			messageMB.error("As senhas não são idênticas.");

			return null;

		} else if (usuarios == null || usuarios.isEmpty()) {

			messageMB.error("Usuário não foi localizado na Base de Dados!");

			return null;

		} else {

			for (Usuario usuario : usuarios) {
				usuario.setSenha(CalcularHashBean.sha256(novaSenha));
				alterarSenhaService.alterarSenha(usuario);

			}
            messageMB.info("Senha alterada com sucesso.");
			reiniciar();  
            loginMB.logOut();
		}

		return "logoff";
	}

	private void reiniciar(){
		usuario = new Usuario();
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
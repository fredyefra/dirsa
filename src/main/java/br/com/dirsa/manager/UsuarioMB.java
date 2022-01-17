package br.com.dirsa.manager;

import java.io.Serializable;

import br.com.dirsa.model.Usuario;

/*@Named("usuarioMB")
@SessionScoped
*/
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	//@Inject
	private Usuario user;
	
	/*@Inject
	private MessageMB messageMB;
	
	private String user;
	private String pass;*/
	
	public UsuarioMB() {}


	/*public boolean login() {
		
		if (user.equals("admin") && pass.equals("admin")) {
			messageMB.info("Logado com sucesso!");
		    return true;
		}
		
		else{
			messageMB.error("Usuário ou Senha Incorreto");
			return false;
		}
		
	}
	*/
	
	/*public boolean isAdmin() {
		return RoleEnum.ADMIN.equals(user.getPapel());
	}
	
	public boolean isDefaultUser() {
		return RoleEnum.USER.equals(user.getPapel());
	}*/


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
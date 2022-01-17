package br.com.dirsa.manager;

import java.io.Serializable;

/*@Named
@SessionScoped*/
public class UsuarioMB2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*@Inject
	private Usuario2 usuarioLogado;
	 
    public Usuario2 getUsuario2() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        usuarioLogado = (Usuario2) session.getAttribute("usuarioLogado");
 
        return usuarioLogado;
    }
 
    public void setUsuario2(Usuario2 usuario2) {
        this.usuarioLogado = usuario2;
    }*/
}
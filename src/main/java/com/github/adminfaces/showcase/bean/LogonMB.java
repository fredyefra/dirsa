package com.github.adminfaces.showcase.bean;

//import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.dirsa.service.bean.IUsuarioService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by rmpestano on 04/02/17.
 */
@ViewScoped
@Named("logonMB")
public class LogonMB implements Serializable {

    private static final long serialVersionUID = 1L;

    //@Inject
    private IUsuarioService usuarioService;
    
	private String email;

    private String password;

    private boolean remember;

    public String doLogon() {
        /*Faces.getFlash().setKeepMessages(true);
        Messages.addGlobalInfo("Logged in successfully!");
        return "index.xhtml?faces-redirect=true";*/
        
    	//usuarioService.login(email, password);
    	
    	
    	Faces.getFlash().setKeepMessages(true);
        usuarioService.login(email, password);
    	Messages.addGlobalInfo("Usuário logado com sucesso!");
        return "home.xhtml?faces-redirect=true";
    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}

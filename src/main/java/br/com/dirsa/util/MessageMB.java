package br.com.dirsa.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "messageMB")
public class MessageMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 * public void info() { FacesContext.getCurrentInstance().addMessage(null,
	 * new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
	 * "Equipamento Salvo(cadastrarEquipamentoMB).")); }
	 */

	public void info(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensagem));
	}

	public void warn(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", mensagem));
	}

	public void error(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", mensagem));
	}

	public void fatal(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
	}

	/*public void mensagem() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		// flash.setRedirect(true);
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sample info message", "PrimeFaces rocks!"));
	}*/
}
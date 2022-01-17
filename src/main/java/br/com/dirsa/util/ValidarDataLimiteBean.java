package br.com.dirsa.util;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;

@Named(value = "validarDataLimiteBean")
public class ValidarDataLimiteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	//private DateTime dataLimite; 
	private Date dataLimite;
	
	public ValidarDataLimiteBean() {
	}

	public Date getDataLimite() {
		dataLimite = new Date();
    	return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
}
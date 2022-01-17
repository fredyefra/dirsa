package br.com.dirsa.service.bean;

import javax.ejb.Local;

import br.com.dirsa.model.OrganizacaoSaudeAeronautica;

@Local
public interface ICadastrarOsaService {

	public void salvar(OrganizacaoSaudeAeronautica osa);

}

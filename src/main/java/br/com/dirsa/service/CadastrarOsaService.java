package br.com.dirsa.service;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dirsa.model.OrganizacaoSaudeAeronautica;
import br.com.dirsa.service.bean.ICadastrarOsaService;

@Stateful
@Named("cadastrarOsaService")
public class CadastrarOsaService implements ICadastrarOsaService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;
	
	@Override
	public void salvar(OrganizacaoSaudeAeronautica osa) {
		em.persist(osa);
	}
}
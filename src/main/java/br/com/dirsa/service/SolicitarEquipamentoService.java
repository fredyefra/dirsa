package br.com.dirsa.service;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dirsa.model.Homologado;
import br.com.dirsa.model.SolicitacaoEquipamento;
import br.com.dirsa.service.bean.ISolicitarEquipamentoService;

@Stateful
@Named("solicitarEquipamentoService")
public class SolicitarEquipamentoService implements ISolicitarEquipamentoService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public void salvar(SolicitacaoEquipamento solicitacaoEquipamento) {
		solicitacaoEquipamento.setHomologado(new Homologado(3));  
		em.persist(solicitacaoEquipamento);
	}
}
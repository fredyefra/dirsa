package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dirsa.model.SolicitacaoEquipamento;
import br.com.dirsa.service.bean.IConsultarSolicitadosService;

@Stateful
@Named("consultarSolicitadosService")
public class ConsultarSolicitadosService implements IConsultarSolicitadosService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public List<SolicitacaoEquipamento> buscarSolicitados() {

		List<SolicitacaoEquipamento> solicitacoes = em
				.createQuery("SELECT solicitacao FROM SolicitacaoEquipamento solicitacao")
				.getResultList();

		return solicitacoes;
	}

	@Override
	public SolicitacaoEquipamento carregarSolicitacao(Integer idSolicitacao) {
		Query query = em
				.createQuery("SELECT solicitacao FROM SolicitacaoEquipamento"
						+ " solicitacao WHERE solicitacao.idSolicitacao =:param")
				.setParameter("param", idSolicitacao);
		SolicitacaoEquipamento solicitacao = (SolicitacaoEquipamento) query.getSingleResult();

		return solicitacao;

	}

	@Override
	public void atualizar(SolicitacaoEquipamento solicitacaoEquipamento) {
		em.merge(solicitacaoEquipamento);
	}

	@Override
	public void salvar(Integer idSolicitacao) {
	
	}
}
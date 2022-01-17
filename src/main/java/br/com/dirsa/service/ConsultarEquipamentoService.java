package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dirsa.model.Equipamento;
import br.com.dirsa.model.Movimentacao;
import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.IConsultarEquipamentoService;

@Stateful
@Named("consultarEquipamentoService")
public class ConsultarEquipamentoService implements IConsultarEquipamentoService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	/**
	 * Seleciona os Equipamentos movimentados e os retira da lista
	 * */
	@Override
	public List<Equipamento> consultarequipamentos() {
          List<Equipamento> equipamentos = em
				//.createQuery("SELECT equipamento FROM Equipamento equipamento WHERE equipamento.movimentado = 0 ")
				.createQuery("SELECT equipamento FROM Equipamento equipamento")
				.getResultList();

		return equipamentos;
	}

	@Override
	public List<Equipamento> consultarEquipamentosCarga(Usuario fkOsa) {
		
		Integer idOsa = fkOsa.getOrganizacaoSaudeAeronautica().getIdOsa();
		
		List<Equipamento> equipamentos = em
				.createQuery("SELECT equipamento FROM Equipamento equipamento WHERE equipamento.usuario.organizacaoSaudeAeronautica.idOsa =:param")
				.setParameter("param", idOsa)
				.getResultList();

		return equipamentos;
	}
	
	@Override
	public Equipamento carregarEquipamento(Integer idEquipamento) {
		Query query = em
				.createQuery("SELECT equipamento FROM Equipamento equipamento WHERE equipamento.idEquipamento =:param")
				.setParameter("param", idEquipamento);
		Equipamento equipamento = (Equipamento) query.getSingleResult();

		return equipamento;
	}

	@Override
	public void salvar(Movimentacao movimentacao) {
		em.persist(movimentacao);
	}

	@Override
	public void atualizar(Movimentacao movimentacao) {
		em.merge(movimentacao);
	}

	@Override
	public void statusMovimentar(Equipamento equipamento) {
		//equipamento.setMovimentado(true);
		em.merge(equipamento);
	}
}
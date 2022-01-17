package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dirsa.model.Movimentacao;
import br.com.dirsa.service.bean.IMovimentarEquipamentoService;

@Stateful
@Named("movimentarEquipamentoService")
public class MovimentarEquipamentoService implements IMovimentarEquipamentoService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public List<Movimentacao> consultarMovimentados() {

		List<Movimentacao> movimentados = em.createQuery(
				//"SELECT movimentacao FROM Movimentacao movimentacao ORDER BY movimentacao.equipamento.numeroPatrimonio ASC")
				"SELECT movimentacao FROM Movimentacao movimentacao")
				.getResultList();

		return movimentados;
	}
}
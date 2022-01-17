package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dirsa.model.Equipamento;
import br.com.dirsa.service.bean.IEquipamentoService;

@Stateful
@Named("equipamentoService")
public class EquipamentoService implements IEquipamentoService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public void salvar(Equipamento equipamento) {
		em.persist(equipamento);
	}

	@Override
	public List<String> verificarPatrimonio() {
	
		List<String> equipamentos = 
				em.createQuery("SELECT equipamento.numeroPatrimonio FROM Equipamento equipamento")
				.getResultList();
		
		return equipamentos;
	}
	
	@Override
	public String helloWord() {
		return "Ola Mundo Testando EJB STATEFUL ....";
	}
}
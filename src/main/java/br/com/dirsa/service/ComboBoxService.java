package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dirsa.model.Especialidade;
import br.com.dirsa.model.Homologado;
import br.com.dirsa.model.Militar;
import br.com.dirsa.model.NomeEquipamento;
import br.com.dirsa.model.NomeFabricante;
import br.com.dirsa.model.OrganizacaoSaudeAeronautica;
import br.com.dirsa.model.Perfil;
import br.com.dirsa.model.PostoGraduacao;
import br.com.dirsa.model.StatusEquipamento;
import br.com.dirsa.model.TipoEquipamento;
import br.com.dirsa.service.bean.IComboBoxService;

@Stateful
@Named("comboBoxService")
public class ComboBoxService implements IComboBoxService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public List<OrganizacaoSaudeAeronautica> buscarOsas() {
		return em.createQuery("SELECT osa FROM OrganizacaoSaudeAeronautica osa").getResultList();
	}

	@Override
	public OrganizacaoSaudeAeronautica findOsa(Integer id) {
		return em.find(OrganizacaoSaudeAeronautica.class, id);
	}

	@Override
	public List<Especialidade> buscarEspecialidades(){
		return em.createQuery("SELECT especialidade FROM Especialidade especialidade").getResultList();
	}

	@Override
	public Especialidade findEspecialidade(Integer id) {
		return em.find(Especialidade.class, id);
	}

	@Override
	public List<TipoEquipamento> buscarTipoEquipamentos() {
		return em.createQuery("SELECT tipoEquipamento FROM TipoEquipamento tipoEquipamento").getResultList();
	}

	@Override
	public TipoEquipamento findTipoEquipamento(Integer id) {
		return em.find(TipoEquipamento.class, id);
	}

	@Override
	public List<NomeEquipamento> buscarNomeEquipamentos() {
		return em.createQuery("SELECT nomeEquipamento FROM NomeEquipamento nomeEquipamento").getResultList();
	}

	@Override
	public NomeEquipamento findNomeEquipamento(Integer id) {
		return em.find(NomeEquipamento.class , id);
	}

	@Override
	public List<NomeFabricante> buscarFabricantes() {
		return em.createQuery("SELECT nomeFabricante FROM NomeFabricante nomeFabricante").getResultList();
	}

	@Override
	public NomeFabricante findNomeFabricante(Integer id) {
		return em.find(NomeFabricante.class, id);
	}

	@Override
	public List<StatusEquipamento> buscarStatusEquipamentos() {
		return em.createQuery("SELECT statusEquipamento FROM StatusEquipamento statusEquipamento").getResultList();
	}

	@Override
	public StatusEquipamento findStatusEquipamento(Integer id) {
		return em.find(StatusEquipamento.class, id);
	}

	@Override
	public List<Perfil> buscarPerfis() {
		return em.createQuery("SELECT perfil FROM Perfil perfil").getResultList();
	}

	@Override
	public Perfil findPerfil(Integer id) {
		return em.find(Perfil.class, id);
	}

	@Override
	public List<PostoGraduacao> buscarPostosGraduacoes() {
		return em.createQuery("SELECT p FROM PostoGraduacao p").getResultList();
	}

	@Override
	public PostoGraduacao findPostoGraduacao(Integer id) {
		return em.find(PostoGraduacao.class, id);
	}

	@Override
	public List<Homologado> buscarHomologados() {
		return em.createQuery("SELECT h FROM Homologado h").getResultList();
	}

	@Override
	public Homologado findHomologado(Integer id) {
		return em.find(Homologado.class, id);
	}

	@Override
	public List<OrganizacaoSaudeAeronautica> buscarOsaPorPerfil(Integer param) {
		List<OrganizacaoSaudeAeronautica> osas = 
				em.createQuery("SELECT osa FROM OrganizacaoSaudeAeronautica osa WHERE osa.perfil.idPerfil =:param")
				.setParameter("param", param)
				.getResultList();

		return osas;
	}

    /*public Militar buscarPorSaram (String saram){
		
		 Query query = em.createQuery("SELECT militar FROM Militar militar WHERE militar.saram =:param")
				  .setParameter("param", saram);
				  Militar militar = (Militar) query.getSingleResult();
		
		return militar;
	}*/
}
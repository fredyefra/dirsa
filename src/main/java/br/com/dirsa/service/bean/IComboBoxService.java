package br.com.dirsa.service.bean;

import java.util.List;
import javax.ejb.Local;
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

@Local
public interface IComboBoxService {

	public List<OrganizacaoSaudeAeronautica> buscarOsas();
	public OrganizacaoSaudeAeronautica findOsa(Integer id);

	public List<Especialidade> buscarEspecialidades();
	public Especialidade findEspecialidade(Integer id); 

	public List<TipoEquipamento> buscarTipoEquipamentos();
	public TipoEquipamento findTipoEquipamento(Integer id);
	
	public List<NomeEquipamento> buscarNomeEquipamentos();
	public NomeEquipamento findNomeEquipamento(Integer id);
	
	public List<NomeFabricante> buscarFabricantes();
	public NomeFabricante findNomeFabricante(Integer id);
	
	public List<StatusEquipamento> buscarStatusEquipamentos();
	public StatusEquipamento findStatusEquipamento(Integer id);
	
	public List<Perfil> buscarPerfis();
	public Perfil findPerfil(Integer id);
	
	public List<PostoGraduacao> buscarPostosGraduacoes();
    public PostoGraduacao findPostoGraduacao(Integer id);

    public List<Homologado> buscarHomologados();
    public Homologado findHomologado(Integer id);

    public List<OrganizacaoSaudeAeronautica> buscarOsaPorPerfil(Integer param);
    //public Militar buscarPorSaram (String saram);

}
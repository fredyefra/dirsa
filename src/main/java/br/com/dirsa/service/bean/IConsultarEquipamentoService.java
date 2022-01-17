package br.com.dirsa.service.bean;

import java.util.List;

import javax.ejb.Local;

import br.com.dirsa.model.Equipamento;
import br.com.dirsa.model.Movimentacao;
import br.com.dirsa.model.Usuario;

@Local
public interface IConsultarEquipamentoService {

	public List<Equipamento> consultarequipamentos();
	public List<Equipamento> consultarEquipamentosCarga(Usuario fkOsa);
	public Equipamento carregarEquipamento(Integer idEquipamento);
    public void salvar(Movimentacao movimentacao);
    public void atualizar(Movimentacao movimentacao);
	public void statusMovimentar(Equipamento equipamento);
}
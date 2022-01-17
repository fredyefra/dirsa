package br.com.dirsa.service.bean;

import java.util.List;

import javax.ejb.Local;

import br.com.dirsa.model.SolicitacaoEquipamento;

@Local
public interface IConsultarSolicitadosService {

	public List<SolicitacaoEquipamento> buscarSolicitados();

	public SolicitacaoEquipamento carregarSolicitacao(Integer idSolicitacao);
	
	public void atualizar(SolicitacaoEquipamento solicitacaoEquipamento);
	
	public void salvar(Integer idSolicitacao);
	
}
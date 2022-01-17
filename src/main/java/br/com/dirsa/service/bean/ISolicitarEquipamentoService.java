package br.com.dirsa.service.bean;

import javax.ejb.Local;

import br.com.dirsa.model.SolicitacaoEquipamento;

@Local
public interface ISolicitarEquipamentoService {

	public void salvar(SolicitacaoEquipamento solicitacaoEquipamento);

}
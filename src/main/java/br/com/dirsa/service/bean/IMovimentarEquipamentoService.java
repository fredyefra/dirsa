package br.com.dirsa.service.bean;

import java.util.List;

import javax.ejb.Local;

import br.com.dirsa.model.Movimentacao;

@Local
public interface IMovimentarEquipamentoService {
	
	public List<Movimentacao> consultarMovimentados();
	
}

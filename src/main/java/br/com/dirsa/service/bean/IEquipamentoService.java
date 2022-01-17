package br.com.dirsa.service.bean;

import java.util.List;

import javax.ejb.Local;

import br.com.dirsa.model.Equipamento;

@Local
public interface IEquipamentoService {

	public void salvar(Equipamento equipamento);
	
	public List<String> verificarPatrimonio();

	public String helloWord();
}
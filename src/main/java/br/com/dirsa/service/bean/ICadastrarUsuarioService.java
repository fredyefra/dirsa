package br.com.dirsa.service.bean;

import java.util.List;

import javax.ejb.Local;

import br.com.dirsa.model.Usuario;

@Local
public interface ICadastrarUsuarioService {

	//public void salvar(Militar militar);
	public void salvar(Usuario usuario); 
	public List<String> verificarSaram(); 
}
package br.com.dirsa.service.bean;

import javax.ejb.Local;

import br.com.dirsa.model.Usuario;

@Local
public interface IUsuarioService {

	public boolean login(String usuario, String senha);

    public Usuario buscarUsuario(String usuario, String senha);

}
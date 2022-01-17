package br.com.dirsa.service.bean;

import java.util.List;

import javax.ejb.Local;

import br.com.dirsa.model.Usuario;

@Local
public interface IAlterarSenhaService {

	public List<Usuario> consultarUsuario(String senha);
    public void alterarSenha(Usuario usuario);

}
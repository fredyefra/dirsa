package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.IAlterarSenhaService;
import br.com.dirsa.util.CalcularHashBean;

@Stateful
@Named("alterarSenhaService")
public class AlterarSenhaService implements IAlterarSenhaService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public List<Usuario> consultarUsuario(String senha) {

		List<Usuario> usuarios = em.createQuery("SELECT usuario FROM Usuario usuario WHERE  usuario.senha = :senha")
				.setParameter("senha",CalcularHashBean.sha256((senha))).getResultList();

		for (Usuario usuario : usuarios) {

			if (!(usuario.getSenha() == null)) {

				usuarios.get(0);	
			}
		}
		return usuarios ; 
	}

	@Override
	public void alterarSenha(Usuario usuario) {
		em.merge(usuario);	
	}
}
package br.com.dirsa.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.ICadastrarUsuarioService;

@Stateful
@Named(value = "cadastrarUsuarioService")
public class CadastrarUsuarioService implements ICadastrarUsuarioService {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;

	@Override
	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public List<String> verificarSaram() {
		
			List<String> saram = 
					em.createQuery("SELECT usuario.saram FROM Usuario usuario")
					.getResultList();
			
			return saram;
		}
}
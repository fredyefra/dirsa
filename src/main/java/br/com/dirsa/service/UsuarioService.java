package br.com.dirsa.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.authentication.UserAlreadyLoggedInException;
import org.picketlink.credential.DefaultLoginCredentials;

import br.com.dirsa.model.Usuario;
import br.com.dirsa.util.CalcularHashBean;
import br.com.dirsa.util.UserGeneric;

/*@Stateful
@Named("usuarioService")*/
@PicketLink
public class UsuarioService extends BaseAuthenticator {

	@PersistenceContext(name = "PERSISTENCE_UNIT")
	private EntityManager em;
    @Inject
	private DefaultLoginCredentials loginCredentials;
   
    @Override
	public void authenticate() {

    	Usuario usuario = null;
    	
		try {
			     usuario = (Usuario) em
				.createQuery("SELECT u FROM Usuario u WHERE (u.saram = :saram OR u.senha = :senha)")
				.setParameter("saram", Long.parseLong(loginCredentials.getUserId()))
				.setParameter("senha", CalcularHashBean.sha256(loginCredentials.getPassword()))
				.getSingleResult();
			
			setStatus(AuthenticationStatus.SUCCESS);
			
			//User user = new User();
			
			UserGeneric user = new UserGeneric();
			user.setFirstName(usuario.getPostoGraduacao().getDsPostoGraduacao());
			user.setLastName(usuario.getNomeGuerra().toUpperCase());
			user.setLoginName(usuario.getPerfil().getDsPerfil());
			user.setEmail(usuario.getOrganizacaoSaudeAeronautica().getDsEscalao());
			user.setUsuario(usuario);
			
			setAccount(user);
              
		} catch (NoResultException nre) {
			setStatus(AuthenticationStatus.FAILURE);
		}

		catch (UserAlreadyLoggedInException uali) {
			setStatus(AuthenticationStatus.FAILURE);
		}
	}
}
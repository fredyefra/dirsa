package br.com.dirsa.util;

import static org.picketlink.idm.model.annotation.IdentityStereotype.Stereotype.USER;

import org.picketlink.idm.model.AttributedType.QUERY_ATTRIBUTE;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.IdentityStereotype;
import org.picketlink.idm.model.basic.Agent;
import org.picketlink.idm.query.QueryParameter;

import br.com.dirsa.model.Militar;
import br.com.dirsa.model.Usuario;

@IdentityStereotype(USER)
public class UserGeneric extends Agent {

	
	private static final long serialVersionUID = -4624939342240447297L;

	 /**
     * A query parameter used to set the firstName value.
     */
    public static final QueryParameter FIRST_NAME = QUERY_ATTRIBUTE.byName("firstName");

    /**
     * A query parameter used to set the lastName value.
     */
    public static final QueryParameter LAST_NAME = QUERY_ATTRIBUTE.byName("lastName");

    /**
     * A query parameter used to set the email value.
     */
    public static final QueryParameter EMAIL = QUERY_ATTRIBUTE.byName("email");

    /**
     * A query parameter used to set the OSA value.
     */
    public static final QueryParameter OSA = QUERY_ATTRIBUTE.byName("usuario");
    
    
    @AttributeProperty
    private String firstName;

    @AttributeProperty
    private String lastName;

    @AttributeProperty
    private String email;

    @AttributeProperty
    private Usuario usuario;
    
    public UserGeneric() {

    }

    public UserGeneric(String loginName) {
        super(loginName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
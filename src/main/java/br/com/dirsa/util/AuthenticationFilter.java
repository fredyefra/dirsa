/*package br.com.dirsa.util;

import org.picketlink.Identity;
import org.picketlink.common.util.StringUtil;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.http.authentication.HttpAuthenticationScheme;
import org.picketlink.http.internal.authentication.schemes.BasicAuthenticationScheme;
import org.picketlink.http.internal.authentication.schemes.DigestAuthenticationScheme;
import org.picketlink.http.internal.authentication.schemes.FormAuthenticationScheme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
	
	 * @author Shane Bryzak
	 * @author Pedro Igor
	 
	@ApplicationScoped
	public class AuthenticationFilter implements Filter {

	    public static final String AUTH_TYPE_INIT_PARAM = "authType";
	    public static final String UNPROTECTED_METHODS_INIT_PARAM = "unprotectedMethods";
	    public static final String FORCE_REAUTHENTICATION_INIT_PARAM = "forceReAuthentication";
	    private final Map authenticationSchemes;
	    private final Set unprotectedMethods;
	    private boolean forceReAuthentication;

	    @Inject
	    private Instance identityInstance;

	    @Inject
	    private Instance credentialsInstance;

	    private HttpAuthenticationScheme authenticationScheme;

	    public AuthenticationFilter() {
	        this.authenticationSchemes = new HashMap();

	        // supported authentication scheme types
	        this.authenticationSchemes.put(AuthType.DIGEST, DigestAuthenticationScheme.class);
	        this.authenticationSchemes.put(AuthType.BASIC, BasicAuthenticationScheme.class);
	        this.authenticationSchemes.put(AuthType.FORM, FormAuthenticationScheme.class);
	        this.authenticationSchemes.put(AuthType.CLIENT_CERT, ClientCertAuthenticationScheme.class);

	        this.unprotectedMethods = new HashSet();
	    }

	    @Override
	    public void init(FilterConfig config) throws ServletException {
	        initAuthenticationScheme(config);

	        String unprotectedMethodsInitParam = config.getInitParameter(UNPROTECTED_METHODS_INIT_PARAM);

	        if (unprotectedMethodsInitParam != null) {
	            if (unprotectedMethodsInitParam.contains(",")) {
	                for (String method : unprotectedMethodsInitParam.split(",")) {
	                    this.unprotectedMethods.add(method.trim().toUpperCase());
	                }
	            } else {
	                this.unprotectedMethods.add(unprotectedMethodsInitParam.trim().toUpperCase());
	            }
	        }

	        String forceReAuthentication = config.getInitParameter(FORCE_REAUTHENTICATION_INIT_PARAM);

	        if (StringUtil.isNullOrEmpty(forceReAuthentication)) {
	            forceReAuthentication = "false";
	        }

	        this.forceReAuthentication = Boolean.valueOf(forceReAuthentication);
	    }

	    @Override
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException,
	            ServletException {
	        if (!HttpServletRequest.class.isInstance(servletRequest)) {
	            throw new ServletException("This filter can only process HttpServletRequest requests.");
	        }

	        final HttpServletRequest request = (HttpServletRequest) servletRequest;
	        final HttpServletResponse response = (HttpServletResponse) servletResponse;
	        Identity identity = getIdentity();

	        DefaultLoginCredentials creds = extractCredentials(request);

	        if (creds.getCredential() != null && this.forceReAuthentication) {
	            identity.logout();
	            creds = extractCredentials(request);
	        }

	        if (isProtected(request) && !identity.isLoggedIn()) {
	            // Force session creation
	            request.getSession();

	            identity.login();

	            if (identity.isLoggedIn()) {
	                if (this.authenticationScheme.postAuthentication(request, response)) {
	                    chain.doFilter(servletRequest, servletResponse);
	                }
	            } else {
	                this.authenticationScheme.challengeClient(request, response);
	            }
	        } else {
	            chain.doFilter(request, response);
	        }
	    }

	    @Override
	    public void destroy() {

	    }

	    private void initAuthenticationScheme(FilterConfig config) {
	        String authTypeName = config.getInitParameter(AUTH_TYPE_INIT_PARAM);

	        if (authTypeName == null) {
	            throw new IllegalArgumentException("Null authentication type provided.");
	        }

	        AuthType authType;

	        try {
	            authType = AuthType.valueOf(authTypeName.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Unsupported authentication type. Possible values are: [" + AuthType.values() + ".", e);
	        }

	        Class authenticationScheme = this.authenticationSchemes.get(authType);

	        if (authenticationScheme == null) {
	            throw new IllegalArgumentException("Authentication type of [" + authType + "] does not match a HTTPAuthenticationScheme type.");
	        }

	        try {
	            this.authenticationScheme = authenticationScheme.getConstructor(FilterConfig.class).newInstance(config);
	        } catch (Exception e) {
	            throw new IllegalStateException("Could not create authentication scheme instance [" + authenticationScheme + "].", e);
	        }
	    }

	    private DefaultLoginCredentials extractCredentials(HttpServletRequest request) {
	        DefaultLoginCredentials creds = getCredentials();

	        this.authenticationScheme.extractCredential(request, creds);

	        return creds;
	    }

	    private DefaultLoginCredentials getCredentials() {
	        if (this.credentialsInstance.isUnsatisfied()) {
	            throw new IllegalStateException(
	                    "DefaultLoginCredentials not found - please ensure that the DefaultLoginCredentials component is created on startup.");
	        } else if (this.credentialsInstance.isAmbiguous()) {
	            throw new IllegalStateException(
	                    "DefaultLoginCredentials is ambiguous. Make sure you have a single @RequestScoped instance.");
	        }

	        try {
	            return credentialsInstance.get();
	        } catch (Exception e) {
	            throw new IllegalStateException("Could not retrieve credentials.", e);
	        }
	    }

	    private Identity getIdentity() throws ServletException {
	        if (this.identityInstance.isUnsatisfied()) {
	            throw new IllegalStateException(
	                    "Identity not found.");
	        } else if (this.identityInstance.isAmbiguous()) {
	            throw new IllegalStateException(
	                    "Identity is ambiguous.");
	        }

	        try {
	            return identityInstance.get();
	        } catch (Exception e) {
	            throw new IllegalStateException("Could not retrieve Identity.", e);
	        }
	    }

	    private boolean isProtected(HttpServletRequest request) {
	        return !this.unprotectedMethods.contains(request.getMethod().toUpperCase());
	    }

	    public enum AuthType {
	        BASIC, DIGEST, FORM, CLIENT_CERT
	    }

	}*/
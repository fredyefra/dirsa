package br.com.dirsa.util;

import javax.enterprise.event.Observes;

import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

public class HttpSecurityConfiguration {

	public void init(@Observes SecurityConfigurationEvent event){
		SecurityConfigurationBuilder builder = event.getBuilder();
		
		builder
        .http()
            .allPaths()
                .authenticateWith()
                    .form()
                        .authenticationUri("/login.xhtml")
                        .loginPage("/login.xhtml")
                        .errorPage("/error.jsf")
                        .restoreOriginalRequest()
            .forPath("/login")
                .logout()
                .redirectTo("/login.xhtml");
		
		/*builder
        .http()
            .allPaths()
                .authenticateWith()
                    .form()
                        .authenticationUri("/login.jsf")
                        .loginPage("/login.jsf")
                        .errorPage("/error.jsf")
                        .restoreOriginalRequest()
            .forPath("/login")
                .logout()
                .redirectTo("/login.jsf");
	
*/	
	}
}
package org.dakhani.spring.bean;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.dakhani.spring.saml.SamlUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginManagedBean {
	
	private String username;


	/**
	 * Log-in user get user credentials.
	 */
	public void doLigin(){
		
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		SamlUser user= (SamlUser) authentication.getDetails();
		this.username = user.getUsername();
		
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}

package org.dakhani.spring.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	public void doLigin() {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		SamlUser user = (SamlUser) authentication.getDetails();
		this.username = user.getUsername();

		// alternate way of fetching username
		// this.username = (String) authentication.getPrincipal();

	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}

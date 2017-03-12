package org.dakhani.spring.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Sami Dakhani Created on Feb 19, 2017
 *
 */
@ManagedBean(name = "loginManager")
@RequestScoped
public class LoginManager {
	
	/**
	 * Authenticates the user
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doAuthenticate() {

		try {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
							.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward((ServletRequest) context.getRequest(),
					(ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
		}

	}

}

package org.dakhani.spring.saml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SamlUser implements UserDetails, Serializable {

	private static final long serialVersionUID = 7786059275980655433L;

	private List<GrantedAuthority> authorities = new ArrayList<>();

	private String emailAddress;

	private String firstname;

	private String lastname;

	private String username;

	public SamlUser(final String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setAuthorities(final List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SamlUser [firstname=" + this.firstname + ", lastname="
				+ this.lastname + "]";
	}

}

package org.dakhani.spring.saml;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.opensaml.saml2.core.Attribute;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;

public class UserDetailsSerice implements SAMLUserDetailsService{
	
	private static final String EMAILADDRESS = "EmailAddress";
	
	private static final String FIRSTNAME = "FirstName";
	
	private static final String LASTNAME = "LastName";

	@Override
	public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
	
		List<Attribute> atributes =credential.getAttributes();
		if(CollectionUtils.isEmpty(atributes)){
			throw new PreAuthenticatedCredentialsNotFoundException("User not found");
		}
		
		SamlUser user = new SamlUser(credential.getAttributeAsString(EMAILADDRESS));
		user.setEmailAddress(credential.getAttributeAsString(EMAILADDRESS));
		user.setFirstname(credential.getAttributeAsString(FIRSTNAME));
		user.setLastname(credential.getAttributeAsString(LASTNAME));
		
		
		return user;
	}

}

package com.bachue.snr.se.libraries.securityConfig;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bachue.snr.se.libraries.shared.business.interfaces.IUsuarioBusiness;
import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Clase que permite configuración de la autenticación JPA para Spring Security (Importante implementar UserDetailsService)
 */
@EJB(name = "usuarioBusiness", beanInterface = IUsuarioBusiness.class)
public class AuthUserJPA implements UserDetailsService {


	/**
	 * Path acceso EJB UserBusinessImpl
	 */
	private static final String USER_EJB_LOOKUP_PATH = "java:global._auto_generated_ear_.SE-ARQ-DEMO.UsuarioBusiness!com.bachue.snr.se.libraries.shared.business.impl.UsuarioBusiness";

	
	/**
	 * Metodo para obtener EJB UserBusinessImpl
	 * @return EJB IUserBusiness
	 */
	private IUsuarioBusiness getUserEJB() {
		try {
			InitialContext initialContext = new InitialContext();
			IUsuarioBusiness userBusiness = (IUsuarioBusiness) initialContext.lookup(USER_EJB_LOOKUP_PATH);
			return userBusiness;
		} catch (NamingException ex) {
			System.out.println("Could not lookup for EJB User with lookup path " + USER_EJB_LOOKUP_PATH);
		}
		return null;
	}
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		IUsuarioBusiness userBussines = getUserEJB();
		UsuarioDTO user = userBussines.consultarUsuario(userName);

		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(userName);
			builder.password("{noop}"+user.getPassword());
			builder.roles(user.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

}

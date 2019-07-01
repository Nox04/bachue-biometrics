package com.bachue.snr.se.libraries.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co
 * Clase que contiene la configuración para filtrar URL publicadas por rol.
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Llamado a la autenticación por JPA
	@Override	 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		 
		auth.userDetailsService(userDetailsService());	 
	}

	//Configuración del filtro URL y autenticación
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();		

		// Patrones permitidos para todos
		http.authorizeRequests().antMatchers( "/secure/login.xhtml", "/appLogout", "/api/**", "/img/**").permitAll();

		//Patrones permitidos servicios web
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/api/usuarios/**").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/img/**").permitAll();

		// Especificacion url permitida para usuarios de tipo ADMIN y USER
		http.authorizeRequests().antMatchers("/pages/users/**").access("hasRole('ADMIN')");
		http.authorizeRequests().antMatchers("/pages/index.xhtml","/pages/numbers/**").access("hasRole('USER') OR hasRole('ADMIN')");

		//Redirección a página no permitida
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/secure/403.xhtml");

		// Configuración de formulario
		http.authorizeRequests().and().formLogin()		

		// Acciones y URL para la autenticación por formulario
		.loginProcessingUrl("/login") // Submit URL
		.loginPage("/secure/login.xhtml")//
		.defaultSuccessUrl("/pages/index.xhtml").successHandler(successHandler())
		.failureUrl("/secure/login.xhtml?error=true")//
		.usernameParameter("username")//
		.passwordParameter("password")		

		// Configuración para cerrar sesión
		.and().logout().  
		
		//URL para cerrar sesión por POST
		logoutUrl("/appLogout").
		logoutSuccessUrl("/secure/login.xhtml");

	}

	@Bean	  
	public UserDetailsService userDetailsService() {		  
		return new AuthUserJPA();	 
	}
	
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    return new MySimpleUrlAuthenticationSuccessHandler();
	}
} 
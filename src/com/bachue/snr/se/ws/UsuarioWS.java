package com.bachue.snr.se.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bachue.snr.se.libraries.shared.business.interfaces.IUsuarioBusiness;
import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Servicio SOAP para publicar servicio de usuarios
 */
@Stateless
@WebService(serviceName = "UsuarioController")
public class UsuarioWS {

	//lombok
	@EJB
	IUsuarioBusiness usuarioBusiness;

	@WebMethod(action = "consultarUsuarios")
	@WebResult(name = "usuarios")
	public List<UsuarioDTO> consultarUsuarios() {
		return usuarioBusiness.consultarUsuarios();
	}

	@WebMethod(action = "consultarUsuario")
	@WebResult(name = "usuario")
	public UsuarioDTO consultarUsuario(@WebParam(name = "idUsuario" ) Integer idUsuario) {
		return usuarioBusiness.consultarUsuario(idUsuario);
	}

	@WebMethod(action="add")
	@WebResult(name = "articles")
	public Boolean addUsuario(@WebParam(name = "usuario") UsuarioDTO usuario) {
		return usuarioBusiness.crearUsuario(usuario);
	}

}

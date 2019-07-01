package com.bachue.snr.se.libraries.shared.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bachue.snr.se.libraries.daos.interfaces.IUsuarioDAO;
import com.bachue.snr.se.libraries.shared.business.interfaces.IUsuarioBusiness;
import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;
import com.bachue.snr.se.libraries.shared.dtos.helper.UsuarioHelper;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Clase que permite gestionar usuario frente a la base de datos
 */
@Stateless(name="UsuarioBusiness", mappedName="ejb/UsuarioBusiness")
@LocalBean
public class UsuarioBusiness implements IUsuarioBusiness {

	@EJB
	private IUsuarioDAO usuarioDao;


	@Override
	public UsuarioDTO consultarUsuario(Integer idUsuario) {
		return UsuarioHelper.toDto(usuarioDao.consultarUsuario(idUsuario));
	}

	@Override
	public UsuarioDTO consultarUsuario(String usuarioName) {
		return UsuarioHelper.toDto(usuarioDao.consultarUsuario(usuarioName));
	}

	@Override
	public List<UsuarioDTO> consultarUsuarios() {		
		return UsuarioHelper.toDto(usuarioDao.consultarUsuarios());
	}
	
	@Override
	public Boolean crearUsuario(UsuarioDTO usuario) {
		return usuarioDao.crearUsuario(UsuarioHelper.toEntity(usuario));
	}
}

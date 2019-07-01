package com.bachue.snr.se.libraries.shared.dtos.helper;


import java.util.ArrayList;
import java.util.List;

import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;
import com.bachue.snr.se.libraries.shared.persistence.model.Usuario;

public class UsuarioHelper {

	private UsuarioHelper() {};

	public static UsuarioDTO toDto(Usuario entidad) {

		UsuarioDTO usuario = new UsuarioDTO();

		usuario.setId(entidad.getId());
		usuario.setEmail(entidad.getEmail());
		usuario.setName(entidad.getName());
		usuario.setPassword(entidad.getPassword());
		usuario.setState(entidad.getState());
		usuario.setRole(entidad.getRole());

		return usuario;
	}


	public static Usuario toEntity(UsuarioDTO modelo) {

		Usuario usuario = new Usuario();

		usuario.setId(modelo.getId());
		usuario.setEmail(modelo.getEmail());
		usuario.setName(modelo.getName());
		usuario.setPassword(modelo.getPassword());
		usuario.setState(modelo.getState());
		usuario.setRole(modelo.getRole());

		return usuario;
	}


	public static List<Usuario> toEntity(List<UsuarioDTO> modelos) {

		List<Usuario> usuarios = new ArrayList<>();

		for (UsuarioDTO modelo : modelos) {			
			usuarios.add(toEntity(modelo));
		}

		return usuarios;
	}
	
	public static List<UsuarioDTO> toDto(List<Usuario> entidades) {

		List<UsuarioDTO> usuarios = new ArrayList<>();

		for (Usuario entidad : entidades) {			
			usuarios.add(toDto(entidad));
		}

		return usuarios;
	}



}

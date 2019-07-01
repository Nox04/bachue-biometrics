package com.bachue.snr.se.libraries.shared.business.interfaces;

import java.util.List;
import javax.ejb.Local;

import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Interfaz que define los metodos para el acceso a la entidad Usuario en la capa de negocio
 */
@Local
public interface IUsuarioBusiness {

	/**
	 * Consulta a un usuario por su id
	 * @param idUsuario identificador de usuario
	 * @return Usuario (DTO)
	 */
	public UsuarioDTO consultarUsuario(Integer idUsuario);
	
	/**
	 * Consulta un usuario por su nombre
	 * @param nombreUsuario nombre de usuario
	 * @return un DTO de usuario
	 */
	public UsuarioDTO consultarUsuario(String nombreUsuario);
	
	/**
	 * Metodo que retorna todos los usuarios existentes
	 * @return Lista de usuarios (DTO)
	 */
	public List<UsuarioDTO> consultarUsuarios();
	
	/**
	 * Crea un usuario a partir de una DTO
	 * @param usuario DTO del usuario  a crear
	 * @return Verdadero o Falso si se crea o no el usuario
	 */
	public Boolean crearUsuario(UsuarioDTO usuario);
	
}

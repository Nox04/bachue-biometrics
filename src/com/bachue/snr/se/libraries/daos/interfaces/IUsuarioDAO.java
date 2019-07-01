package com.bachue.snr.se.libraries.daos.interfaces;

import java.util.List;
import javax.ejb.Local;

import com.bachue.snr.se.libraries.shared.persistence.model.Usuario;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Interfaz que define los metodos para acceder a los usuarios en la BD
 */
@Local
public interface IUsuarioDAO {

	/**
	 * Consulta un usuario por su Id
	 * @param idUsuario identificacion del usuario a consultar
	 * @return usuario encontrado
	 */
	public Usuario consultarUsuario(Integer idUsuario);

	/**
	 * Consulta un usuario por su Id
	 * @param nombreUsuario nombre del usuario a consultar
	 * @return usuario encontrado
	 */
	public Usuario consultarUsuario(String nombreUsuario);

	/**
	 * Consulta de todos los usuario
	 * @return Lista de usuarios encontrados
	 */
	public List<Usuario> consultarUsuarios();


	/**
	 * Metodo que permite crear usuario
	 * @param usuario Entidad usuario a crear
	 * @return confirmacion booleana si fue posible la creacion
	 */
	public Boolean crearUsuario(Usuario usuario);


}

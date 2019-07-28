package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IUsuarioDAO;
import com.bachue.snr.biometrico.admon.persistence.model.Usuario;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de interface de DAO que permite la gestion de usuarios.
 *
 */
@Stateless
@Local
public class UsuarioDAOImpl implements IUsuarioDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public Boolean crearUsuario(Usuario au_usuario) {
		try {
			EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
			lem_entityManager.persist(au_usuario);
			lem_entityManager.close();
		}catch (Exception le_e) {
			return false;
		}
		return true;
	}

	@Override
	public Usuario consultarUsuario(String idUsuario) {
		EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
		Usuario lu_usuario = lem_entityManager.find(Usuario.class, idUsuario);
		lem_entityManager.close();
		return lu_usuario;
	}
}

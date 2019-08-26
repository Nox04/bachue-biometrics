package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHistoricoDAO;
import com.bachue.snr.biometrico.admon.persistence.model.Historico;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de interface de DAO que permite la gestion de usuarios.
 *
 */
@Stateless
@Local
public class HistoricoDAOImpl implements IHistoricoDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public Boolean crearHistorico(Historico ah_historico) {
		try {
			EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
			lem_entityManager.persist(ah_historico);
			lem_entityManager.close();
		}catch (Exception le_e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Historico> consultarUltimasCincoClaves(String idUsuario) {
		EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();

		String query = "SELECT u FROM Historico u WHERE u.idUsuario =:usuarioId order by u.fechaCreacion desc ";
		return lem_entityManager.createQuery(query, Historico.class).setParameter("usuarioId", idUsuario).setMaxResults(5).getResultList();
	}

}

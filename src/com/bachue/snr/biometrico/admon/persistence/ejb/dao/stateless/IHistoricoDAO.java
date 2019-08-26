package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Historico;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de logs.
 *
 */
@Local
public interface IHistoricoDAO {
  /**
   * Metodo que registra el usuario en la tabla de usuarios.
   * @param ah_historico Modelo que sera almacenado en la base de datos.
   * @return true si el usuario es registrado con exito.
   */
  Boolean crearHistorico(Historico ah_historico);


  /**
   * Metodo que consulta un usuario en la tabla de usuarios.
   * @param idUsuario id del usuario consultado.
   * @return las ultimas cinco claves
   */
  List<Historico> consultarUltimasCincoClaves(String idUsuario);
}

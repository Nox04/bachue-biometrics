package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Constante;

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
public interface IConstanteDAO {
  /**
   * Metodo que obtiene las constantes en la tabla de constantes.
   * @return lista de las constantes.
   */
  List<Constante> obtenerConstantes();
}

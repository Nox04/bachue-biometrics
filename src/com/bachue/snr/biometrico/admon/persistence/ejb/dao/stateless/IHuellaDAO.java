package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de operaciones biométricas.
 *
 */
@Local
public interface IHuellaDAO {
  /**
   * Método que agrega los campos de auditoria que son obtenibles desde el request.
   * @param idUsuario Request con la información HTTP de la petición recibida.
   * @return true si la huella es consultada con éxito.
   */
  Boolean consultarHuella(Integer idUsuario);
}

package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Huella;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de operaciones biometricas.
 *
 */
@Local
public interface IHuellaDAO {
  /**
   * Metodo que agrega los campos de auditoria que son obtenibles desde el request.
   * @param ah_huella Request con la informacion HTTP de la peticion recibida.
   * @return true si la huella es consultada con exito.
   */
  Boolean crearHuella(Huella ah_huella);

  Boolean borrarHuellas(String as_idUsuario);
}

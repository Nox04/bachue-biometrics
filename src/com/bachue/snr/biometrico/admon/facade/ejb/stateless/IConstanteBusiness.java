package com.bachue.snr.biometrico.admon.facade.ejb.stateless;


import com.bachue.snr.biometrico.admon.persistence.dto.ConstantesSalidaDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de negocio de constantes.
 *
 */
public interface IConstanteBusiness {

  /**
   * Metodo que obtiene las constantes de la base de datos.
   * @return lista de las constantes.
   */
  ConstantesSalidaDTO obtenerConstantes();
}

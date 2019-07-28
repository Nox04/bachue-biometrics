package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de operaciones biometricas.
 *
 */
public interface IHuellaBusiness {
  /**
   * Metodo que extrae y envia los datos de la huella al DAO para ser almacenada.
   * @param ahd_huella DTO con la informacion de la huella.
   * @return true si la huella es enrolada con exito.
   */
  Boolean enrolarHuella(HuellaDTO ahd_huella);

  /**
   * Metodo que compara los datos de la huella con los registros biometricos almacenados.
   * @param avd_verificacion DTO con la informacion de la huella.
   * @return true si la huella es procesada con exito. Incluso si el resultado es negativo.
   */
  Boolean verificarHuella(VerificacionDTO avd_verificacion);
}

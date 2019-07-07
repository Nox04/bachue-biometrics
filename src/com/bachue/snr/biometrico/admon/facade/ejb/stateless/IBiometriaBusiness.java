package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de lógica de operaciones biométricas.
 *
 */
public interface IBiometriaBusiness {
  /**
   * Método que extrae y envía los datos de la huella al DAO para ser almacenada.
   * @param huella DTO con la información de la huella.
   * @return true si la huella es enrolada con éxito.
   */
  Boolean enrolarHuella(HuellaDTO huella);

  /**
   * Método que compara los datos de la huella con los registros biométricos almacenados.
   * @param huella DTO con la información de la huella.
   * @return true si la huella es procesada con éxito. Incluso si el resultado es negativo.
   */
  Boolean verificarHuella(HuellaDTO huella);
}

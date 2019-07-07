package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de lógica de operaciones biométricas.
 *
 */
public interface IHuellaBusiness {
  /**
   * Método que extrae y envía los datos de la huella al DAO para ser almacenada.
   * @param ahd_huella DTO con la información de la huella.
   * @return true si la huella es enrolada con éxito.
   */
  Boolean enrolarHuella(HuellaDTO ahd_huella);

  /**
   * Método que compara los datos de la huella con los registros biométricos almacenados.
   * @param ahd_huella DTO con la información de la huella.
   * @return true si la huella es procesada con éxito. Incluso si el resultado es negativo.
   */
  Boolean verificarHuella(HuellaDTO ahd_huella);
}

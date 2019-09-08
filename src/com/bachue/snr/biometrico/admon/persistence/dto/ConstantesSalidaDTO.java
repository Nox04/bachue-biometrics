package com.bachue.snr.biometrico.admon.persistence.dto;

import com.bachue.snr.biometrico.admon.persistence.model.Constante;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de salida de constantes.
 *
 */
public class ConstantesSalidaDTO extends BaseSalidaDTO {
  private ArrayList<Constante> ilc_constantes;

  @XmlElement(name = "constante")
  public ArrayList<Constante> getConstantes() {
    return ilc_constantes;
  }

  public void setConstantes(ArrayList<Constante> alc_constantes) {
    this.ilc_constantes = alc_constantes;
  }
}

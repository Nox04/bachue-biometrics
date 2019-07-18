package com.bachue.snr.biometrico.admon.enums;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Enum que relaciona dedos y su posicion en la mano.
 *
 */
public enum DedosEnum {
  PULGAR_DERECHO("1", "pulgar derecho"),
  INDICE_DERECHO("2", "índice derecho"),
  CORAZON_DERECHO("3", "corazón derecho"),
  ANULAR_DERECHO("4", "anular derecho"),
  MENIQUE_DERECHO("5", "meñique derecho"),
  PULGAR_IZQUIERDO("6", "pulgar izquierdo"),
  INDICE_IZQUIERDO("7", "índice izquierdo"),
  CORAZON_IZQUIERDO("8", "corazón izquierdo"),
  ANULAR_IZQUIERDO("9", "anular izquierdo"),
  MENIQUE_IZQUIERDO("10", "meñique izquierdo");

  private final String cs_nombre;
  private final String cs_posicion;

  DedosEnum(final String as_posicion, String as_nombre) {
    this.cs_nombre = as_nombre;
    this.cs_posicion = as_posicion;
  }

  /**
   * Metodo que retorna el nombre del dedo.
   * @return el nombre del dedo.
   */
  public String consultarNombre() {
    return cs_nombre;
  }

  /**
   * Metodo que retorna la posicion del dedo.
   * @return la posicion del dedo.
   */
  public String consultarPosicion() {
    return cs_posicion;
  }

  /**
   * Metodo que retorna el cs_nombre del dedo al darle una posicion especifica.
   * @return el cs_nombre del dedo.
   */
  public static String consultarDedoPorPosicion(String as_posicion) {
    for (DedosEnum l_dedo : DedosEnum.values()) {
      if (as_posicion.equals(l_dedo.cs_posicion)) {
        return l_dedo.cs_nombre;
      }
    }
    return null;
  }
}

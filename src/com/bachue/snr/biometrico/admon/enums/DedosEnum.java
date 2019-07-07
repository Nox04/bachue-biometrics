package com.bachue.snr.biometrico.admon.enums;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Enum que relaciona dedos y su posición en la mano.
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

  private final String nombre;
  private final String posicion;

  DedosEnum(final String posicion, String nombre) {
    this.nombre = nombre;
    this.posicion = posicion;
  }

  public String obtenerNombre() {
    return nombre;
  }

  public String obtenerPosicion() {
    return posicion;
  }

  public static String obtenerDedoPorPosicion(String posicion) {
    for (DedosEnum dedo : DedosEnum.values()) {
      if (posicion.equals(dedo.posicion)) {
        return dedo.nombre;
      }
    }
    return null;
  }
}

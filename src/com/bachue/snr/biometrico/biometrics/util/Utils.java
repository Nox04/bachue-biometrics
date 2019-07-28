package com.bachue.snr.biometrico.biometrics.util;

class Utils {

  static final String SEPARADOR_DE_ARCHIVOS = System.getProperty("file.separator");
  static final String SEPARADOR_DE_CARPETAS = System.getProperty("path.separator");


  private Utils() {}

  /**
   * Devuelve el directorio activo.
   * @return direccctorio activo.
   */
  static String obtenerDirectorioActivo() {
    return System.getProperty("user.dir");
  }


  static boolean esNuloOVacio(String as_value) {
    return as_value == null || "".equals(as_value);
  }
}

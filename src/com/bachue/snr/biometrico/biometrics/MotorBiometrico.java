package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.biometrics.util.ManejadorDeLibrerias;
import com.neurotec.biometrics.NMatchingSpeed;
import com.neurotec.biometrics.NTemplateSize;
import com.neurotec.biometrics.client.NBiometricClient;
import com.neurotec.licensing.NLicense;
import com.neurotec.licensing.NLicenseManager;
import com.neurotec.plugins.NDataFileManager;

public class MotorBiometrico {

  private static MotorBiometrico imb_instancia;
  private NBiometricClient inbc_cliente;

  private MotorBiometrico() {
    this.inicializarMotor();
  }

  public static MotorBiometrico getInstance() {
    if(imb_instancia == null) {
      imb_instancia = new MotorBiometrico();
    }

    return imb_instancia;
  }

  /**
   * Setup everything before start biometric engine.
   */
  private void inicializarMotor() {
    ManejadorDeLibrerias.inicializarLibrerias();
    configurarLicencias();
    configurarCliente();
  }

  private  void configurarLicencias() {
    String[] ls_licencias = { "FingerMatcher", "FingerExtractor"};
    boolean lb_existeAlgunaLicencia = false;
    NLicenseManager.setTrialMode(true);
    try {
      for (String ls_licencia : ls_licencias) {
        if (NLicense.obtain("/local", 5000, ls_licencia)) {
          System.out.format("Obtained license: %s%n", ls_licencia);
          lb_existeAlgunaLicencia = true;
        }
      }
      if (!lb_existeAlgunaLicencia) {
        System.err.println("Could not obtain any matching license");
      }
    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
    }
  }

  private  void configurarCliente() {
    this.inbc_cliente = new NBiometricClient();
    this.inbc_cliente.setDatabaseConnectionToSQLite("cache.db");
    this.inbc_cliente.setFingersTemplateSize(NTemplateSize.LARGE);
    this.inbc_cliente.setMatchingThreshold(40);
    this.inbc_cliente.setFingersMatchingSpeed(NMatchingSpeed.HIGH);
    this.inbc_cliente.setMatchingMaximalResultCount(1);
    NDataFileManager.getInstance().addFromDirectory("data", false);
  }

  public NBiometricClient getCliente() {
    return inbc_cliente;
  }
}

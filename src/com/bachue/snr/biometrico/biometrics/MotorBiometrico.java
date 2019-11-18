package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.biometrics.util.ManejadorDeLibrerias;
import com.bachue.snr.biometrico.biometrics.util.Utils;
import com.neurotec.biometrics.NMatchingSpeed;
import com.neurotec.biometrics.NTemplateSize;
import com.neurotec.biometrics.client.NBiometricClient;
import com.neurotec.biometrics.client.NDatabaseBiometricConnection;
import com.neurotec.licensing.NLicense;
import com.neurotec.licensing.NLicenseManager;
import com.neurotec.plugins.NDataFile;
import com.neurotec.plugins.NDataFileManager;
import com.neurotec.samples.util.LicenseManager;

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
    imb_instancia.configurarLicencias();
    imb_instancia.reconfigurarCliente();
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
    String[] ls_licencias = { "FingerMatcher", "FingerExtractor" };
    boolean lb_existeAlgunaLicencia = false;
    try {
      for (String ls_licencia : ls_licencias) {
        if (NLicense.obtain("/local", 5000, ls_licencia)) {
          System.err.format("Obtained license: %s%n", ls_licencia);
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
    reconfigurarCliente();
  }

  private void reconfigurarCliente() {
    String domainDir = System.getenv("DOMAIN_HOME");
    NDataFileManager.getInstance().addFromDirectory(domainDir + Utils.SEPARADOR_DE_ARCHIVOS + "bin" + Utils.SEPARADOR_DE_ARCHIVOS + "data", false);
    NDataFile[] files = NDataFileManager.getInstance().getAllFiles();
    for(NDataFile ndf : files) {
      System.err.println("BRS Data files: " + ndf.getFileName());
    }
  }

  public NBiometricClient getCliente() {
    return inbc_cliente;
  }
}

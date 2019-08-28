package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.persistence.model.Huella;
import com.neurotec.biometrics.NBiometricStatus;
import com.neurotec.biometrics.NMatchingSpeed;
import com.neurotec.biometrics.NSubject;
import com.neurotec.io.NBuffer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class Verificador {


  public boolean verificar(VerificacionDTO avd_verificacion, List<Huella> alh_huellas) {
    NSubject lns_subjectCandidate = new NSubject();
    NSubject lns_subjectProbe = new NSubject();

    try {
      crearCarpeta(avd_verificacion.getUsuarioId());
      byte[] lb_data = Base64.decodeBase64(avd_verificacion.getTemplate());

      FileUtils.writeByteArrayToFile(new File("biometria/cache/" + Criptografia.decrypt(avd_verificacion.getUsuarioId())+ ".bmp"), lb_data);
      NBuffer lnb_bufferCandidate = Extractor.crearTemplate("biometria/cache/" + Criptografia.decrypt(avd_verificacion.getUsuarioId()) + ".bmp");

      for (Huella lh_huella: alh_huellas) {
        FileUtils.writeByteArrayToFile(new File("biometria/cache/" + Criptografia.decrypt(avd_verificacion.getUsuarioId())+ "/cache.bmp"), lh_huella.getTemplate());
        NBuffer lnb_bufferProbe = Extractor.crearTemplate("biometria/cache/" + Criptografia.decrypt(avd_verificacion.getUsuarioId())+ "/cache.bmp");
        if(lnb_bufferProbe != null && lnb_bufferCandidate != null){
          lns_subjectCandidate.setTemplateBuffer(lnb_bufferCandidate);
          lns_subjectProbe.setTemplateBuffer(lnb_bufferProbe);

          MotorBiometrico.getInstance().getCliente().setFingersMatchingSpeed(NMatchingSpeed.LOW);
          NBiometricStatus lnbs_status = MotorBiometrico.getInstance().getCliente().verify(lns_subjectProbe, lns_subjectCandidate);
          if (lnbs_status == NBiometricStatus.OK) {
            return true;
          }
        } else {
          return false;
        }
      }
      return false;
    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
      return false;
    }
  }
  private void crearCarpeta(String as_idUsuario) {
    File lf_carpeta = new File("biometria/cache");
    File lf_carpetaUsuario = new File("biometria/cache/" + Criptografia.decrypt(as_idUsuario));
    if (!lf_carpeta.exists()) lf_carpeta.mkdirs();
    if (!lf_carpetaUsuario.exists()) lf_carpetaUsuario.mkdirs();
  }
}

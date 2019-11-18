package com.bachue.snr.biometrico.biometrics;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Criptografia {

  private static byte[] keyArray = { 124, 114, 73, 16, 9, 117, 8, 74, 105, 72, 27, 111, 86, 107, 67, 120 };

  private Criptografia() {}

  public static String encrypt(String strToEncrypt) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      IvParameterSpec ivSpec = new IvParameterSpec(keyArray);
      Key secretKey = new SecretKeySpec(keyArray, "AES");

      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

      return Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
    } catch (Exception e) {
      System.err.println("[Exception]:"+e.getMessage());
    }
    return null;
  }

  public static String decrypt(String encryptedMessage) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      IvParameterSpec ivSpec = new IvParameterSpec(keyArray);
      Key secretKey = new SecretKeySpec(keyArray, "AES");

      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
      byte[] decodedMessage = Base64.decodeBase64(encryptedMessage);
      return new String(cipher.doFinal(decodedMessage));
    } catch (Exception e) {
      System.err.println("[Exception]:" + e.getMessage());
    }
    return null;
  }
}

package util;

import javax.crypto.*;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Security {

    private static final String key = "museum";

    public static String encrypt(String senha) {
        try {
            byte[] keyData = (key).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] hash = cipher.doFinal(senha.getBytes());
            return new String(Base64.getEncoder().encode(hash));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String senha) {
        try {
            byte[] keyData = (key).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] hash = cipher.doFinal(Base64.getDecoder().decode(senha));
            return new String(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}

package atividade_10_05_2022;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {
	
	public static byte[] encrypt(byte[] plaintext, SecretKey key) throws Exception {
		byte[] nonceBytes = new byte[12];
		int counter = 5;
		
		Cipher cipher = Cipher.getInstance("ChaCha20");

		ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonceBytes, counter);
				
		SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "ChaCha20");

		cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);

		byte[] cipherText = cipher.doFinal(plaintext);

		return cipherText;
	}

	public static String decrypt(byte[] cipherText, SecretKey key) throws Exception {
		byte[] nonceBytes = new byte[12];
		int counter = 5;

		Cipher cipher = Cipher.getInstance("ChaCha20");

		ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonceBytes, counter);
				
		SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "ChaCha20");

		cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);

		byte[] decryptedText = cipher.doFinal(cipherText);

		return new String(decryptedText);
	}
	
}
